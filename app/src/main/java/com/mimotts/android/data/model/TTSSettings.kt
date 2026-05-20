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
    val styleInstruction: String = "",
    val styleTags: List<String> = emptyList(),
    val historyItems: List<TTSHistoryItem> = emptyList()
) {
    // 数据验证和修复，确保设置始终有效
    fun validated(): TTSSettings {
        return copy(
            // 确保音频格式是有效值
            audioFormat = try {
                if (AudioFormat.entries.any { it.name == audioFormat.name }) {
                    audioFormat
                } else {
                    AudioFormat.WAV
                }
            } catch (e: Exception) {
                AudioFormat.WAV
            },
            // 确保选中的音色在预置音色列表中
            selectedVoice = if (selectedVoice in PRESET_VOICES) selectedVoice else "冰糖",
            // 确保模型是有效值
            selectedModel = try {
                if (TTSModel.entries.any { it.name == selectedModel.name }) {
                    selectedModel
                } else {
                    TTSModel.PRESET
                }
            } catch (e: Exception) {
                TTSModel.PRESET
            }
        )
    }
}

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
enum class AudioFormat(val apiValue: String) {
    WAV("wav"),
    MP3("mp3"),
    FLAC("flac"),
    M4A("m4a"),
    OGG("ogg");
    
    companion object {
        fun fromString(value: String): AudioFormat {
            return entries.find { it.name.equals(value, ignoreCase = true) } ?: WAV
        }
    }
}

val PRESET_VOICES = listOf(
    "冰糖", "茉莉", "苏打", "白桦",
    "Mia", "Chloe", "Milo", "Dean"
)

val TAG_GROUPS = listOf(
    TagGroup(
        name = "基础情绪",
        tags = listOf("开心", "悲伤", "愤怒", "恐惧", "惊讶", "兴奋", "委屈", "平静", "冷漠")
    ),
    TagGroup(
        name = "复合情绪",
        tags = listOf("怅然", "欣慰", "无奈", "愧疚", "释然", "嫉妒", "厌倦", "忐忑", "动情")
    ),
    TagGroup(
        name = "整体语调",
        tags = listOf("温柔", "高冷", "活泼", "严肃", "慵懒", "俏皮", "深沉", "干练", "凌厉")
    ),
    TagGroup(
        name = "音色定位",
        tags = listOf("磁性", "醇厚", "清亮", "空灵", "稚嫩", "苍老", "甜美", "沙哑", "醇雅")
    ),
    TagGroup(
        name = "人设腔调",
        tags = listOf("夹子音", "御姐音", "正太音", "大叔音", "台湾腔")
    ),
    TagGroup(
        name = "方言",
        tags = listOf("东北话", "四川话", "河南话", "粤语")
    ),
    TagGroup(
        name = "角色扮演",
        tags = listOf("孙悟空", "林黛玉")
    ),
    TagGroup(
        name = "唱歌",
        tags = listOf("唱歌")
    ),
    TagGroup(
        name = "音效",
        tags = listOf("吸气", "深呼吸", "叹气", "长叹一口气", "喘息", "屏息",
            "紧张", "害怕", "激动", "疲惫", "委屈", "撒娇", "心虚", "震惊", "不耐烦",
            "颤抖", "声音颤抖", "变调", "破音", "鼻音", "气声",
            "笑", "轻笑", "大笑", "冷笑", "抽泣", "呜咽", "哽咽", "嚎啕大哭")
    )
)

@Serializable
data class TagGroup(
    val name: String,
    val tags: List<String>
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
