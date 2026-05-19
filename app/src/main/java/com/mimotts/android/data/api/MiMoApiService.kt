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
                header("api-key", token)
                timeout {
                    requestTimeoutMillis = 120000 // 增加到120秒，音色克隆可能需要更长时间
                }
                setBody(request)
            }

            if (response.status.value != 200) {
                return Result.failure(Exception("API 请求失败 (HTTP ${response.status.value})，请检查 API Key"))
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
        voiceDescription: String?
    ): List<Message> {
        return when {
            model.contains("voicedesign") -> {
                // 音色设计：通过 user 消息描述音色，assistant 消息提供文本
                val voiceDesignPrompt = voiceDescription?.takeIf { it.isNotBlank() }
                    ?: "自然流畅的声音"
                val finalPrompt = if (styleInstruction.isNotBlank()) {
                    "$voiceDesignPrompt，$styleInstruction"
                } else voiceDesignPrompt

                listOf(
                    Message(role = "user", content = finalPrompt),
                    Message(role = "assistant", content = text)
                )
            }
            model.contains("voiceclone") -> {
                // 音色克隆：user 消息可选，assistant 消息提供合成文本
                val messages = mutableListOf<Message>()
                if (styleInstruction.isNotBlank()) {
                    messages.add(Message(role = "user", content = styleInstruction))
                }
                messages.add(Message(role = "assistant", content = text))
                messages
            }
            else -> {
                // 预设音色：user 消息可包含风格指令
                listOf(
                    Message(
                        role = "user",
                        content = styleInstruction.takeIf { it.isNotBlank() } ?: ""
                    ),
                    Message(role = "assistant", content = text)
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
        return when {
            model.contains("voiceclone") -> {
                // 音色克隆：必须提供音频样本的 base64
                AudioPayload(
                    format = format,
                    voice = voiceCloneBase64
                )
            }
            model.contains("voicedesign") -> {
                // 音色设计：不支持 voice 字段
                AudioPayload(format = format)
            }
            else -> {
                // 预设音色
                AudioPayload(
                    format = format,
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
