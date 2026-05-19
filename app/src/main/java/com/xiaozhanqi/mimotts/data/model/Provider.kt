package com.xiaozhanqi.mimotts.data.model

import kotlinx.serialization.Serializable
import kotlin.uuid.Uuid

@Serializable
sealed class ProviderSetting {
    abstract val id: Uuid
    abstract val name: String
    abstract val apiKey: String
    abstract val enabled: Boolean
    abstract val models: List<TTSModel>

    @Serializable
    data class MiMoPlan(
        override val id: Uuid,
        override val name: String,
        val baseUrl: String = "https://token-plan-cn.xiaomimimo.com/v1",
        override val apiKey: String = "",
        override val enabled: Boolean = true,
        override val models: List<TTSModel> = DEFAULT_MIMO_MODELS
    ) : ProviderSetting()

    @Serializable
    data class ApiKey(
        override val id: Uuid,
        override val name: String,
        val baseUrl: String = "https://api.xiaomimimo.com/v1",
        override val apiKey: String = "",
        override val enabled: Boolean = true,
        override val models: List<TTSModel> = DEFAULT_MIMO_MODELS
    ) : ProviderSetting()
}

@Serializable
data class TTSModel(
    val id: Uuid,
    val modelId: String,
    val displayName: String,
    val type: ModelType,
    val voices: List<Voice> = emptyList()
)

@Serializable
enum class ModelType {
    PRESET_VOICE,
    VOICE_DESIGN,
    VOICE_CLONE
}

@Serializable
data class Voice(
    val id: String,
    val name: String,
    val description: String = ""
)

// 默认模型配置
val DEFAULT_MIMO_MODELS = listOf(
    TTSModel(
        id = Uuid.parse("a1b2c3d4-e5f6-7890-abcd-ef1234567890"),
        modelId = "mimo-v2.5-tts",
        displayName = "🎙️ 预置音色",
        type = ModelType.PRESET_VOICE,
        voices = listOf(
            Voice("bingtang", "冰糖", "甜美清澈的女声"),
            Voice("moli", "茉莉", "温柔知性的女声"),
            Voice("suda", "苏打", "活泼轻快的女声"),
            Voice("baihua", "白桦", "沉稳磁性的男声"),
            Voice("mia", "Mia", "英文女声"),
            Voice("chloe", "Chloe", "英文女声"),
            Voice("milo", "Milo", "英文男声"),
            Voice("dean", "Dean", "英文男声")
        )
    ),
    TTSModel(
        id = Uuid.parse("b2c3d4e5-f6a7-8901-bcde-f23456789012"),
        modelId = "mimo-v2.5-tts-voicedesign",
        displayName = "✨ 音色设计",
        type = ModelType.VOICE_DESIGN,
        voices = emptyList()
    ),
    TTSModel(
        id = Uuid.parse("c3d4e5f6-a7b8-9012-cdef-345678901234"),
        modelId = "mimo-v2.5-tts-voiceclone",
        displayName = "🎭 音色克隆",
        type = ModelType.VOICE_CLONE,
        voices = emptyList()
    )
)

// 默认提供商
val DEFAULT_PROVIDERS = listOf(
    ProviderSetting.MiMoPlan(
        id = Uuid.parse("d4e5f6a7-b8c9-0123-defa-456789012345"),
        name = "MiMo Plan",
        enabled = true
    ),
    ProviderSetting.ApiKey(
        id = Uuid.parse("e5f6a7b8-c9d0-1234-efab-567890123456"),
        name = "API Key",
        enabled = false
    )
)
