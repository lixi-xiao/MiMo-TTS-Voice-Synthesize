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
        apiMode: ApiMode,
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

            val request = ChatCompletionRequest(
                model = model,
                messages = messages,
                audio = audioPayload
            )

            val response: ChatCompletionResponse = client.post("$baseUrl/chat/completions") {
                contentType(ContentType.Application.Json)
                header("Authorization", "Bearer $token")
                timeout {
                    requestTimeoutMillis = 60000
                }
                setBody(request)
            }.body()

            val audioData = response.choices
                ?.firstOrNull()
                ?.message
                ?.audio
                ?.data

            if (audioData != null) {
                Result.success(Base64.decode(audioData, Base64.DEFAULT))
            } else {
                Result.failure(Exception("API 未返回音频数据"))
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
            else -> {
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
                AudioPayload(
                    format = format,
                    voice = voiceCloneBase64
                )
            }
            model.contains("voicedesign") -> {
                AudioPayload(format = format)
            }
            else -> {
                AudioPayload(
                    format = format,
                    voice = voice
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
    val audio: AudioResponse? = null
)

@Serializable
data class AudioResponse(
    val data: String? = null
)


