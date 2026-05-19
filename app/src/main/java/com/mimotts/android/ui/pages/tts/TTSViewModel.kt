package com.mimotts.android.ui.pages.tts

import android.net.Uri
import androidx.compose.foundation.text.input.TextFieldState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mimotts.android.data.model.ApiMode
import com.mimotts.android.data.api.MiMoApiService
import com.mimotts.android.data.datastore.SettingsDataStore
import com.mimotts.android.data.model.AudioFormat
import com.mimotts.android.data.model.TTSModel
import com.mimotts.android.data.model.TTSSettings
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import java.io.File
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class TTSViewModel(
    private val settingsDataStore: SettingsDataStore,
    private val apiService: MiMoApiService
) : ViewModel() {

    val textState = TextFieldState()
    
    private val _settings = MutableStateFlow(TTSSettings())
    val settings: StateFlow<TTSSettings> = _settings.asStateFlow()
    
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

    init {
        viewModelScope.launch {
            settingsDataStore.settingsFlow.collect { settings ->
                _settings.value = settings
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

    fun updateApiMode(apiMode: ApiMode) {
        viewModelScope.launch {
            settingsDataStore.updateApiMode(apiMode)
        }
    }

    fun updatePlanToken(token: String) {
        viewModelScope.launch {
            settingsDataStore.updatePlanToken(token)
        }
    }

    fun updateApiKey(apiKey: String) {
        viewModelScope.launch {
            settingsDataStore.updateApiKey(apiKey)
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

    fun generateSpeech(cacheDir: File) {
        viewModelScope.launch {
            val text = textState.text.toString().trim()
            if (text.isEmpty()) {
                _error.value = "请输入要合成的文本"
                return@launch
            }

            val currentSettings = _settings.value
            val token = when (currentSettings.apiMode) {
                ApiMode.PLAN -> currentSettings.planToken
                ApiMode.API_KEY -> currentSettings.apiKey
            }

            if (token.isBlank()) {
                _error.value = when (currentSettings.apiMode) {
                    ApiMode.PLAN -> "请输入 Plan Token"
                    ApiMode.API_KEY -> "请输入 API Key"
                }
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

                val baseUrl = when (currentSettings.apiMode) {
                    ApiMode.PLAN -> currentSettings.planEndpoint
                    ApiMode.API_KEY -> currentSettings.apiEndpoint
                }

                val voiceCloneBase64 = if (currentSettings.selectedModel == TTSModel.VOICE_CLONE) {
                    _voiceCloneUri.value?.let { uri ->
                        cacheDir.resolve("temp_clone").readBytes().let {
                            android.util.Base64.encodeToString(it, android.util.Base64.DEFAULT)
                        }
                    }
                } else null

                val result = apiService.synthesizeSpeech(
                    apiMode = currentSettings.apiMode,
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
                    val file = File(cacheDir, filename)
                    file.writeBytes(audioData)
                    _audioUri.value = Uri.fromFile(file)
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
}
