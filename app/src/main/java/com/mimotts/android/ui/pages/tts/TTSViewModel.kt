package com.mimotts.android.ui.pages.tts

import android.content.Context
import android.net.Uri
import androidx.compose.foundation.text.input.TextFieldState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mimotts.android.data.model.ApiConfig
import com.mimotts.android.data.model.DEFAULT_API_CONFIG
import com.mimotts.android.data.api.MiMoApiService
import com.mimotts.android.data.datastore.SettingsDataStore
import com.mimotts.android.data.model.AudioFormat
import com.mimotts.android.data.model.TTSModel
import com.mimotts.android.data.model.TTSHistoryItem
import com.mimotts.android.data.model.TTSSettings
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.io.File
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.UUID

class TTSViewModel(
    private val settingsDataStore: SettingsDataStore,
    private val apiService: MiMoApiService
) : ViewModel() {

    val textState = TextFieldState()

    private val _settings = MutableStateFlow(TTSSettings())
    val settings: StateFlow<TTSSettings> = _settings.asStateFlow()

    private val _activeApiConfig = MutableStateFlow<ApiConfig?>(null)
    val activeApiConfig: StateFlow<ApiConfig?> = _activeApiConfig.asStateFlow()

    private val _isGenerating = MutableStateFlow(false)
    val isGenerating: StateFlow<Boolean> = _isGenerating.asStateFlow()

    private val _generatedAudio = MutableStateFlow<ByteArray?>(null)
    val generatedAudio: StateFlow<ByteArray?> = _generatedAudio.asStateFlow()

    private val _audioUri = MutableStateFlow<Uri?>(null)
    val audioUri: StateFlow<Uri?> = _audioUri.asStateFlow()

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error.asStateFlow()

    private val _activeTags = MutableStateFlow<Set<String>>(emptySet())
    val activeTags: StateFlow<Set<String>> = _activeTags.asStateFlow()

    private val _voiceCloneUri = MutableStateFlow<Uri?>(null)
    val voiceCloneUri: StateFlow<Uri?> = _voiceCloneUri.asStateFlow()

    private val _historyItems = MutableStateFlow<List<TTSHistoryItem>>(emptyList())
    val historyItems: StateFlow<List<TTSHistoryItem>> = _historyItems.asStateFlow()

    init {
        viewModelScope.launch {
            settingsDataStore.settingsFlow.collect { settings ->
                // 确保默认有一个预填配置
                val finalSettings = if (settings.apiConfigs.isEmpty()) {
                    val updated = settings.copy(
                        apiConfigs = listOf(DEFAULT_API_CONFIG),
                        activeApiId = DEFAULT_API_CONFIG.id
                    )
                    settingsDataStore.updateSettings(updated)
                    updated
                } else {
                    settings
                }
                _settings.value = finalSettings
                _activeApiConfig.value = finalSettings.apiConfigs.find { it.id == finalSettings.activeApiId }
                _historyItems.value = finalSettings.historyItems
            }
        }
    }

    fun toggleTag(tagName: String, tagText: String) {
        val currentTags = _activeTags.value.toMutableSet()
        val currentText = textState.text.toString()

        if (currentTags.contains(tagName)) {
            currentTags.remove(tagName)
            textState.edit {
                replace(0, length, currentText.replace(tagText, ""))
            }
        } else {
            currentTags.add(tagName)
            textState.edit {
                replace(0, length, currentText + tagText)
            }
        }
        _activeTags.value = currentTags
    }

    fun clearAll() {
        textState.edit { replace(0, length, "") }
        _activeTags.value = emptySet()
        _generatedAudio.value = null
        _audioUri.value = null
        _error.value = null
        _voiceCloneUri.value = null
    }

    fun setVoiceCloneUri(uri: Uri?) {
        _voiceCloneUri.value = uri
    }

    fun updateApiKey(apiKey: String) {
        viewModelScope.launch {
            val current = _settings.value
            val activeConfig = current.apiConfigs.find { it.id == current.activeApiId }
            if (activeConfig != null) {
                val updatedConfig = activeConfig.copy(apiKey = apiKey)
                settingsDataStore.updateApiConfig(updatedConfig)
            }
        }
    }

    fun addApiConfig(name: String, apiKey: String, endpoint: String) {
        viewModelScope.launch {
            val config = ApiConfig(
                id = UUID.randomUUID().toString(),
                name = name,
                apiKey = apiKey,
                apiEndpoint = endpoint
            )
            settingsDataStore.addApiConfig(config)
        }
    }

    fun removeApiConfig(id: String) {
        viewModelScope.launch {
            settingsDataStore.removeApiConfig(id)
        }
    }

    fun updateApiConfigName(id: String, name: String) {
        viewModelScope.launch {
            val current = _settings.value
            val config = current.apiConfigs.find { it.id == id }
            if (config != null) {
                settingsDataStore.updateApiConfig(config.copy(name = name))
            }
        }
    }

    fun setActiveApiId(id: String) {
        viewModelScope.launch {
            settingsDataStore.setActiveApiId(id)
        }
    }

    fun updateSelectedModel(model: TTSModel) {
        viewModelScope.launch {
            settingsDataStore.updateSelectedModel(model)
        }
    }

    fun updateSelectedVoice(voice: String) {
        viewModelScope.launch {
            settingsDataStore.updateSelectedVoice(voice)
        }
    }

    fun updateVoiceDescription(description: String) {
        viewModelScope.launch {
            settingsDataStore.updateVoiceDescription(description)
        }
    }

    fun updateAudioFormat(format: AudioFormat) {
        viewModelScope.launch {
            settingsDataStore.updateAudioFormat(format)
        }
    }

    fun updateStyleInstruction(instruction: String) {
        viewModelScope.launch {
            settingsDataStore.updateStyleInstruction(instruction)
        }
    }

    fun generateSpeech(context: Context) {
        viewModelScope.launch {
            val text = textState.text.toString().trim()
            if (text.isEmpty()) {
                _error.value = "请输入要合成的文本"
                return@launch
            }

            val currentSettings = _settings.value
            val activeConfig = currentSettings.apiConfigs.find { it.id == currentSettings.activeApiId }

            val token = activeConfig?.apiKey ?: currentSettings.apiKey

            if (token.isBlank()) {
                _error.value = "请输入 API Key"
                return@launch
            }

            _isGenerating.value = true
            _error.value = null

            try {
                val modelId = when (currentSettings.selectedModel) {
                    TTSModel.PRESET -> "mimo-v2.5-tts"
                    TTSModel.VOICE_DESIGN -> "mimo-v2.5-tts-voicedesign"
                    TTSModel.VOICE_CLONE -> "mimo-v2.5-tts-voiceclone"
                }

                val baseUrl = activeConfig?.apiEndpoint ?: currentSettings.apiEndpoint

                val voiceCloneBase64 = if (currentSettings.selectedModel == TTSModel.VOICE_CLONE) {
                    _voiceCloneUri.value?.let { uri ->
                        try {
                            context.contentResolver.openInputStream(uri)?.use { inputStream ->
                                val bytes = inputStream.readBytes()
                                android.util.Base64.encodeToString(bytes, android.util.Base64.DEFAULT)
                            }
                        } catch (e: Exception) {
                            _error.value = "读取音频文件失败: ${e.message}"
                            _isGenerating.value = false
                            return@launch
                        }
                    } ?: run {
                        _error.value = "请先选择要克隆的音频文件"
                        _isGenerating.value = false
                        return@launch
                    }
                } else null

                val result = apiService.synthesizeSpeech(
                    token = token,
                    baseUrl = baseUrl,
                    model = modelId,
                    text = text,
                    styleInstruction = currentSettings.styleInstruction,
                    voice = currentSettings.selectedVoice.takeIf { currentSettings.selectedModel == TTSModel.PRESET },
                    voiceDescription = currentSettings.voiceDescription.takeIf { currentSettings.selectedModel == TTSModel.VOICE_DESIGN },
                    voiceCloneBase64 = voiceCloneBase64,
                    format = currentSettings.audioFormat.name.lowercase()
                )

                result.onSuccess { audioData ->
                    _generatedAudio.value = audioData

                    // Save to file
                    val timestamp = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(Date())
                    val prefix = when (currentSettings.selectedModel) {
                        TTSModel.VOICE_DESIGN -> "voicedesign"
                        else -> currentSettings.selectedVoice
                    }
                    val filename = "mimo_tts_${prefix}_$timestamp.${currentSettings.audioFormat.name.lowercase()}"
                    val file = File(context.cacheDir, filename)
                    file.writeBytes(audioData)
                    _audioUri.value = Uri.fromFile(file)

                    // 添加到历史记录
                    val historyItem = TTSHistoryItem(
                        id = UUID.randomUUID().toString(),
                        text = text,
                        model = currentSettings.selectedModel,
                        voice = when (currentSettings.selectedModel) {
                            TTSModel.PRESET -> currentSettings.selectedVoice
                            TTSModel.VOICE_DESIGN -> currentSettings.voiceDescription
                            TTSModel.VOICE_CLONE -> "音色克隆"
                        },
                        audioUrl = file.absolutePath,
                        createdAt = System.currentTimeMillis()
                    )
                    settingsDataStore.addHistoryItem(historyItem)
                    _historyItems.value = listOf(historyItem) + _historyItems.value
                }.onFailure { e ->
                    _error.value = "合成失败: ${e.message}"
                }
            } catch (e: Exception) {
                _error.value = "合成失败: ${e.message}"
            } finally {
                _isGenerating.value = false
            }
        }
    }

    fun dismissError() {
        _error.value = null
    }

    fun clearHistory() {
        viewModelScope.launch {
            settingsDataStore.clearHistory()
            _historyItems.value = emptyList()
        }
    }

    fun removeHistoryItem(id: String) {
        viewModelScope.launch {
            settingsDataStore.removeHistoryItem(id)
            _historyItems.value = _historyItems.value.filter { it.id != id }
        }
    }

    fun downloadAudio(context: Context, uri: Uri) {
        viewModelScope.launch {
            try {
                // 获取音频数据
                val audioData = _generatedAudio.value
                if (audioData == null) {
                    _error.value = "音频数据不可用"
                    return@launch
                }

                // 保存到 Downloads 目录
                val downloadsDir = android.os.Environment.getExternalStoragePublicDirectory(
                    android.os.Environment.DIRECTORY_DOWNLOADS
                )
                val currentSettings = _settings.value
                val timestamp = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(Date())
                val prefix = when (currentSettings.selectedModel) {
                    TTSModel.VOICE_DESIGN -> "voicedesign"
                    TTSModel.VOICE_CLONE -> "voiceclone"
                    else -> currentSettings.selectedVoice
                }
                val filename = "mimo_tts_${prefix}_$timestamp.${currentSettings.audioFormat.name.lowercase()}"
                val file = File(downloadsDir, filename)
                file.writeBytes(audioData)

                // 通知系统扫描新文件
                android.media.MediaScannerConnection.scanFile(
                    context,
                    arrayOf(file.absolutePath),
                    arrayOf("audio/${currentSettings.audioFormat.name.lowercase()}"),
                    null
                )

                _error.value = "已保存到下载目录: $filename"
            } catch (e: Exception) {
                _error.value = "下载失败: ${e.message}"
            }
        }
    }
}
