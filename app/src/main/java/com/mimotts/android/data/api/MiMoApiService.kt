package com.mimotts.android.data.api

import android.util.Base64
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.timeout
import io.ktor.client.request.header
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

class MiMoApiService {
    private val client = HttpClient(OkHttp) {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                isLenient = true
            })
        }
    }

    suspend fun synthesizeSpeech(
        token: String,
        baseUrl: String,
        model: String,
        text: String,
        styleInstruction: String = "",
        styleTags: List<String> = emptyList(),
        voice: String? = null,
        voiceDescription: String? = null,
        voiceCloneBase64: String? = null,
        format: String = "wav"
    ): Result<ByteArray> {
        return try {
            val messages = buildMessages(
                model = model,
                text = text,
                styleInstruction = styleInstruction,
                styleTags = styleTags,
                voiceDescription = voiceDescription
            )

            val audioPayload = buildAudioPayload(
                model = model,
                voice = voice,
                voiceCloneBase64 = voiceCloneBase64,
                format = format
            )

            // 音色克隆必须提供音频样本
            if (model.contains("voiceclone") && voiceCloneBase64.isNullOrBlank()) {
                return Result.failure(Exception("音色克隆需要提供音频样本"))
            }

            val request = ChatCompletionRequest(
                model = model,
                messages = messages,
                audio = audioPayload
            )

            val response: HttpResponse = client.post("$baseUrl/chat/completions") {
                contentType(ContentType.Application.Json)
                header("Authorization", "Bearer $token")
                header("api-key", token)
                timeout {
                    requestTimeoutMillis = 120000 // 增加到120秒，音色克隆可能需要更长时间
                }
                setBody(request)
            }

            val statusCode = response.status.value
            if (statusCode != 200) {
                // 尝试获取详细的错误信息
                val errorBody = try {
                    response.body<String>()
                } catch (e: Exception) {
                    null
                }
                
                val errorMsg = when (statusCode) {
                    400 -> {
                        val detail = errorBody?.takeIf { it.isNotBlank() } ?: "请求格式错误"
                        "API 请求参数错误 (HTTP 400): $detail"
                    }
                    401 -> "API Key 无效或已过期，请在设置中检查"
                    403 -> "API Key 无权限访问此资源"
                    429 -> "请求频率超限，请稍后再试（建议等待1-2分钟）"
                    500, 502, 503 -> "服务器暂时不可用，请稍后再试"
                    else -> "API 请求失败 (HTTP $statusCode): ${errorBody?.take(200) ?: ""}"
                }
                return Result.failure(Exception(errorMsg))
            }

            val body: ChatCompletionResponse = response.body()

            val audioData = body.choices
                ?.firstOrNull()
                ?.message
                ?.audio
                ?.data

            if (audioData != null) {
                Result.success(Base64.decode(audioData, Base64.DEFAULT))
            } else {
                val contentMsg = body.choices?.firstOrNull()?.message?.content
                val errorMsg = if (!contentMsg.isNullOrBlank()) {
                    "API 未返回音频数据: $contentMsg"
                } else if (body.choices.isNullOrEmpty()) {
                    "API 返回空结果，请检查 API Key 是否有效"
                } else {
                    "API 未返回音频数据，请检查音频样本格式（仅支持 mp3 和 wav）"
                }
                Result.failure(Exception(errorMsg))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    private fun buildMessages(
        model: String,
        text: String,
        styleInstruction: String,
        styleTags: List<String>,
        voiceDescription: String?
    ): List<Message> {
        // 构建带标签的合成文本：标签放在文本开头
        val taggedText = if (styleTags.isNotEmpty()) {
            "(${styleTags.joinToString(" ")})$text"
        } else {
            text
        }

        return when {
            model.contains("voicedesign") -> {
                val voiceDesignPrompt = voiceDescription?.takeIf { it.isNotBlank() }
                    ?: "自然流畅的声音"
                val finalPrompt = if (styleInstruction.isNotBlank()) {
                    "$voiceDesignPrompt，$styleInstruction"
                } else voiceDesignPrompt

                listOf(
                    Message(role = "user", content = finalPrompt),
                    Message(role = "assistant", content = taggedText)
                )
            }
            model.contains("voiceclone") -> {
                val messages = mutableListOf<Message>()
                if (styleInstruction.isNotBlank()) {
                    messages.add(Message(role = "user", content = styleInstruction))
                }
                messages.add(Message(role = "assistant", content = taggedText))
                messages
            }
            else -> {
                listOf(
                    Message(
                        role = "user",
                        content = styleInstruction.takeIf { it.isNotBlank() } ?: ""
                    ),
                    Message(role = "assistant", content = taggedText)
                )
            }
        }
    }

    private fun buildAudioPayload(
        model: String,
        voice: String?,
        voiceCloneBase64: String?,
        format: String
    ): AudioPayload {
        // 确保格式有效
        val validFormats = listOf("mp3", "flac", "m4a", "wav", "ogg")
        val safeFormat = if (format.lowercase() in validFormats) format.lowercase() else "wav"
        
        return when {
            model.contains("voiceclone") -> {
                // 音色克隆：voice 使用 Data URI 格式（由ViewModel根据文件MIME类型构建）
                AudioPayload(
                    format = safeFormat,
                    voice = voiceCloneBase64
                )
            }
            model.contains("voicedesign") -> {
                // 音色设计：不支持 voice 字段
                AudioPayload(format = safeFormat)
            }
            else -> {
                // 预设音色
                AudioPayload(
                    format = safeFormat,
                    voice = voice ?: "mimo_default"
                )
            }
        }
    }
}

@Serializable
data class ChatCompletionRequest(
    val model: String,
    val messages: List<Message>,
    val audio: AudioPayload
)

@Serializable
data class Message(
    val role: String,
    val content: String
)

@Serializable
data class AudioPayload(
    val format: String,
    val voice: String? = null
)

@Serializable
data class ChatCompletionResponse(
    val choices: List<Choice>? = null
)

@Serializable
data class Choice(
    val message: MessageResponse? = null
)

@Serializable
data class MessageResponse(
    val audio: AudioResponse? = null,
    val content: String? = null
)

@Serializable
data class AudioResponse(
    val data: String? = null
)
