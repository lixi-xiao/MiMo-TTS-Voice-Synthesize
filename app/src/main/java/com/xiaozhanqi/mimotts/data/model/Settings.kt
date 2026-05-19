package com.xiaozhanqi.mimotts.data.model

import kotlinx.serialization.Serializable
import kotlin.uuid.Uuid

@Serializable
data class Settings(
    val dynamicColor: Boolean = true,
    val darkMode: DarkMode = DarkMode.SYSTEM,
    val amoledDark: Boolean = false,
    val providers: List<ProviderSetting> = DEFAULT_PROVIDERS,
    val selectedProviderId: Uuid = DEFAULT_PROVIDERS[0].id,
    val selectedModelId: Uuid = DEFAULT_MIMO_MODELS[0].id,
    val selectedVoiceId: String = "bingtang",
    val audioFormat: AudioFormat = AudioFormat.WAV,
    val voiceDescription: String = "",
    val defaultStyleInstruction: String = "",
    val recentTexts: List<String> = emptyList(),
    val maxRecentTexts: Int = 10
) {
    companion object {
        fun default() = Settings()
    }
}

@Serializable
enum class DarkMode {
    SYSTEM, LIGHT, DARK
}

@Serializable
enum class AudioFormat {
    WAV, MP3
}

@Serializable
enum class EmotionTag(val displayName: String, val tag: String) {
    HAPPY("开心", "(开心)"),
    SAD("悲伤", "(悲伤)"),
    GENTLE("温柔", "(温柔)"),
    LAZY("慵懒", "(慵懒)"),
    ANGRY("愤怒", "(愤怒)"),
    SURPRISED("惊讶", "(惊讶)")
}

@Serializable
enum class DialectTag(val displayName: String, val tag: String) {
    NORTHEAST("东北话", "(东北话)"),
    CANTONESE("粤语", "(粤语)"),
    SICHUAN("四川话", "(四川话)")
}

@Serializable
enum class StyleTag(val displayName: String, val tag: String) {
    SINGING("唱歌", "(唱歌)"),
    WHISPER("耳语", "(耳语)")
}

@Serializable
enum class SoundEffectTag(val displayName: String, val tag: String) {
    LAUGH("笑", "[笑]"),
    SIGH("叹气", "[叹气]"),
    INHALE("吸气", "[吸气]")
}

// 扩展函数
fun Settings.getSelectedProvider(): ProviderSetting? {
    return providers.find { it.id == selectedProviderId }
}

fun Settings.getSelectedModel(): TTSModel? {
    return providers.flatMap { it.models }
        .find { it.id == selectedModelId }
}

fun Settings.getSelectedVoice(): Voice? {
    return getSelectedModel()?.voices?.find { it.id == selectedVoiceId }
}
