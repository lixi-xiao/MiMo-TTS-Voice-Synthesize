package com.mimotts.android.data.model

import kotlinx.serialization.Serializable

@Serializable
data class TTSSettings(
    val apiKey: String = "",
    val apiEndpoint: String = "https://api.xiaomimimo.com/v1",
    val activeApiId: String = "",
    val apiConfigs: List<ApiConfig> = emptyList(),
    val selectedModel: TTSModel = TTSModel.PRESET,
    val selectedVoice: String = "冰糖",
    val voiceDescription: String = "",
    val audioFormat: AudioFormat = AudioFormat.WAV,
    val styleInstruction: String = ""
)

@Serializable
data class ApiConfig(
    val id: String = "",  // UUID格式
    val name: String = "",  // 用户自定义名称
    val apiKey: String = "",
    val apiEndpoint: String = "https://api.xiaomimimo.com/v1"
)

val DEFAULT_API_CONFIG = ApiConfig(
    id = "default",
    name = "按量付费 (默认)",
    apiKey = "",
    apiEndpoint = "https://api.xiaomimimo.com/v1"
)

@Serializable
enum class TTSModel {
    PRESET,        // 预置音色
    VOICE_DESIGN,  // 音色设计
    VOICE_CLONE    // 音色克隆
}

@Serializable
enum class AudioFormat {
    WAV,
    MP3
}

val PRESET_VOICES = listOf(
    "冰糖", "茉莉", "苏打", "白桦",
    "Mia", "Chloe", "Milo", "Dean"
)

val TAG_GROUPS = listOf(
    TagGroup(
        name = "情感",
        tags = mapOf(
            "开心" to "(开心)",
            "悲伤" to "(悲伤)",
            "温柔" to "(温柔)",
            "慵懒" to "(慵懒)",
            "愤怒" to "(愤怒)",
            "惊讶" to "(惊讶)"
        )
    ),
    TagGroup(
        name = "方言",
        tags = mapOf(
            "东北话" to "(东北话)",
            "粤语" to "(粤语)",
            "四川话" to "(四川话)"
        )
    ),
    TagGroup(
        name = "风格",
        tags = mapOf(
            "唱歌" to "(唱歌)",
            "耳语" to "(耳语)"
        )
    ),
    TagGroup(
        name = "音效",
        tags = mapOf(
            "笑" to "[笑]",
            "叹气" to "[叹气]",
            "吸气" to "[吸气]"
        )
    )
)

@Serializable
data class TagGroup(
    val name: String,
    val tags: Map<String, String>
)

@Serializable
data class TTSHistoryItem(
    val id: String,
    val text: String,
    val model: TTSModel,
    val voice: String,
    val audioUrl: String?,
    val createdAt: Long
)
