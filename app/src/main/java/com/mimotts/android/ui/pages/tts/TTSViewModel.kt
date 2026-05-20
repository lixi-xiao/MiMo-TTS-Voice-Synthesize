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
import java.nio.ByteBuffer
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.UUID

class TTSViewModel(
    private val settingsDataStore: SettingsDataStore,
    private val apiService: MiMoApiService
) : ViewModel() {

    data class LogEntry(
        val timestamp: Long = System.currentTimeMillis(),
        val level: String, // "INFO", "ERROR", "SUCCESS", "DEBUG"
        val message: String
    )

    companion object {
        // 使用静态列表存储日志，确保跨页面、跨ViewModel实例共享
        private val _staticLogEntries = MutableStateFlow<List<LogEntry>>(emptyList())
        val logEntries: StateFlow<List<LogEntry>> = _staticLogEntries.asStateFlow()

        private fun addLogStatic(level: String, message: String) {
            val entry = LogEntry(timestamp = System.currentTimeMillis(), level = level, message = message)
            _staticLogEntries.value = (_staticLogEntries.value + entry).takeLast(500)
            android.util.Log.d("MiMoTTS", "[$level] $message")
        }

        fun clearLogsStatic() {
            _staticLogEntries.value = emptyList()
        }
    }

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

    fun toggleTag(tag: String) {
        val currentTags = _settings.value.styleTags.toMutableList()
        if (currentTags.contains(tag)) {
            currentTags.remove(tag)
        } else {
            currentTags.add(tag)
        }
        viewModelScope.launch {
            settingsDataStore.updateStyleTags(currentTags)
        }
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

                addLogStatic("INFO", "========== 开始合成 ==========")
                addLogStatic("INFO", "模型: $modelId")
                addLogStatic("INFO", "文本: ${text.take(50)}${if (text.length > 50) "..." else ""}")
                addLogStatic("INFO", "音频格式: ${currentSettings.audioFormat.name}")
                addLogStatic("INFO", "API: ${activeConfig?.apiEndpoint ?: currentSettings.apiEndpoint}")
                
                if (currentSettings.styleTags.isNotEmpty()) {
                    addLogStatic("INFO", "风格标签: ${currentSettings.styleTags.joinToString(", ")}")
                }
                if (currentSettings.styleInstruction.isNotBlank()) {
                    addLogStatic("INFO", "风格指令: ${currentSettings.styleInstruction.take(50)}")
                }

                val baseUrl = activeConfig?.apiEndpoint ?: currentSettings.apiEndpoint

                val voiceCloneBase64 = if (currentSettings.selectedModel == TTSModel.VOICE_CLONE) {
                    _voiceCloneUri.value?.let { uri ->
                        try {
                            context.contentResolver.openInputStream(uri)?.use { inputStream ->
                                val originalBytes = inputStream.readBytes()
                                addLogStatic("INFO", "原始音频: ${originalBytes.size} bytes")

                                // 检查文件大小（API限制10MB）
                                if (originalBytes.size > 10 * 1024 * 1024) {
                                    addLogStatic("ERROR", "音频文件过大: ${originalBytes.size} bytes > 10MB")
                                    _error.value = "音频文件过大，请上传小于10MB的文件"
                                    _isGenerating.value = false
                                    return@launch
                                }

                                // 验证音频文件是否有效
                                val originalMimeType = context.contentResolver.getType(uri)
                                addLogStatic("INFO", "原始MIME: $originalMimeType, 大小: ${originalBytes.size} bytes")

                                // 尝试解析音频文件，验证是否为有效音频
                                var isValidAudio = false
                                var audioDuration = 0L
                                try {
                                    val mmr = android.media.MediaMetadataRetriever()
                                    context.contentResolver.openFileDescriptor(uri, "r")?.use { pfd ->
                                        mmr.setDataSource(pfd.fileDescriptor)
                                    }
                                    val duration = mmr.extractMetadata(android.media.MediaMetadataRetriever.METADATA_KEY_DURATION)
                                    audioDuration = duration?.toLong() ?: 0L
                                    mmr.release()
                                    isValidAudio = true
                                    addLogStatic("INFO", "音频有效，时长: ${audioDuration}ms")
                                } catch (e: Exception) {
                                    addLogStatic("ERROR", "音频文件无效: ${e.message}")
                                    isValidAudio = false
                                }

                                if (!isValidAudio) {
                                    addLogStatic("ERROR", "无法解析音频文件，请确保文件格式正确")
                                    _error.value = "音频文件格式不支持或已损坏，请尝试其他音频文件（支持 mp3/wav/m4a/ogg/flac）"
                                    _isGenerating.value = false
                                    return@launch
                                }

                                // 检测并转码为 WAV 格式
                                var finalBytes = originalBytes
                                var finalMimeType = "audio/wav"

                                // 如果不是 WAV 格式，尝试转码
                                if (originalMimeType != null && !originalMimeType.contains("wav")) {
                                    addLogStatic("INFO", "检测到非WAV格式($originalMimeType)，正在转码为WAV...")
                                    try {
                                        finalBytes = convertToWav(context, uri)
                                        finalMimeType = "audio/wav"
                                        addLogStatic("SUCCESS", "转码成功: WAV ${finalBytes.size} bytes")
                                    } catch (e: Exception) {
                                        addLogStatic("WARN", "转码失败(${e.message})，使用原始文件")
                                        finalBytes = originalBytes
                                        // 根据原始MIME类型设置
                                        finalMimeType = when {
                                            originalMimeType.contains("mp3") || originalMimeType.contains("mpeg") -> "audio/mpeg"
                                            originalMimeType.contains("ogg") -> "audio/ogg"
                                            originalMimeType.contains("m4a") || originalMimeType.contains("mp4") -> "audio/mp4"
                                            originalMimeType.contains("flac") -> "audio/flac"
                                            else -> "audio/wav"
                                        }
                                    }
                                }

                                val base64 = android.util.Base64.encodeToString(finalBytes, android.util.Base64.NO_WRAP)
                                addLogStatic("INFO", "最终: mime=$finalMimeType, size=${finalBytes.size}, base64Len=${base64.length}")

                                // 验证Data URI格式
                                val dataUri = "data:$finalMimeType;base64,$base64"
                                if (dataUri.length > 10000000) {
                                    addLogStatic("ERROR", "Data URI 过长: ${dataUri.length}")
                                    _error.value = "音频文件过大，请上传更小的文件"
                                    _isGenerating.value = false
                                    return@launch
                                }

                                dataUri
                            }
                        } catch (e: Exception) {
                            addLogStatic("ERROR", "读取音频文件失败: ${e.message}")
                            _error.value = "读取音频文件失败: ${e.message}"
                            _isGenerating.value = false
                            return@launch
                        }
                    } ?: run {
                        addLogStatic("ERROR", "未选择音频文件")
                        _error.value = "请先选择要克隆的音频文件"
                        _isGenerating.value = false
                        return@launch
                    }
                } else null

                val safeFormat = when (currentSettings.audioFormat) {
                    AudioFormat.MP3 -> "mp3"
                    AudioFormat.WAV -> "wav"
                    AudioFormat.FLAC -> "flac"
                    AudioFormat.M4A -> "m4a"
                    AudioFormat.OGG -> "ogg"
                    else -> "wav"  // 兜底，永远不可能走到这里但以防万一
                }
                addLogStatic("DEBUG", "audioFormat枚举: ${currentSettings.audioFormat.name}, 发送格式: $safeFormat")

                val result = apiService.synthesizeSpeech(
                    token = token,
                    baseUrl = baseUrl,
                    model = modelId,
                    text = text,
                    styleInstruction = currentSettings.styleInstruction,
                    styleTags = currentSettings.styleTags,
                    voice = currentSettings.selectedVoice.takeIf { currentSettings.selectedModel == TTSModel.PRESET },
                    voiceDescription = currentSettings.voiceDescription.takeIf { currentSettings.selectedModel == TTSModel.VOICE_DESIGN },
                    voiceCloneBase64 = voiceCloneBase64,
                    format = safeFormat
                )

                result.onSuccess { audioData ->
                    _generatedAudio.value = audioData

                    // Save to file
                    val timestamp = SimpleDateFormat("yyyy-M-d_HH-mm", Locale.getDefault()).format(Date())
                    val modeName = when (currentSettings.selectedModel) {
                        TTSModel.VOICE_DESIGN -> "voicedesign"
                        TTSModel.VOICE_CLONE -> "voiceclone"
                        else -> currentSettings.selectedVoice
                    }
                    val filename = "${timestamp}_${modeName}.${currentSettings.audioFormat.name.lowercase()}"
                    val file = File(context.cacheDir, filename)
                    file.writeBytes(audioData)
                    _audioUri.value = Uri.fromFile(file)

                    addLogStatic("SUCCESS", "合成成功: ${file.name}")

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
                    addLogStatic("ERROR", "合成失败: ${e.message}")
                }
            } catch (e: Exception) {
                _error.value = "合成失败: ${e.message}"
                addLogStatic("ERROR", "合成失败: ${e.message}")
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

    fun downloadAudio(context: Context, customFilename: String? = null) {
        viewModelScope.launch {
            try {
                // 获取音频数据
                val audioData = _generatedAudio.value
                if (audioData == null) {
                    _error.value = "音频数据不可用"
                    return@launch
                }

                val currentSettings = _settings.value

                // 使用自定义文件名或默认文件名
                val filename = if (!customFilename.isNullOrBlank()) {
                    // 确保有正确的扩展名
                    val ext = currentSettings.audioFormat.name.lowercase()
                    if (customFilename.endsWith(".$ext")) customFilename else "$customFilename.$ext"
                } else {
                    val timestamp = SimpleDateFormat("yyyy-M-d_HH-mm", Locale.getDefault()).format(Date())
                    val modeName = when (currentSettings.selectedModel) {
                        TTSModel.VOICE_DESIGN -> "voicedesign"
                        TTSModel.VOICE_CLONE -> "voiceclone"
                        else -> currentSettings.selectedVoice
                    }
                    "${timestamp}_${modeName}.${currentSettings.audioFormat.name.lowercase()}"
                }

                // 使用 MediaStore API 保存到 Downloads
                val contentValues = android.content.ContentValues().apply {
                    put(android.provider.MediaStore.Downloads.DISPLAY_NAME, filename)
                    put(android.provider.MediaStore.Downloads.MIME_TYPE, "audio/${currentSettings.audioFormat.name.lowercase()}")
                    put(android.provider.MediaStore.Downloads.RELATIVE_PATH, android.os.Environment.DIRECTORY_DOWNLOADS)
                }

                val resolver = context.contentResolver
                val uri = resolver.insert(android.provider.MediaStore.Downloads.EXTERNAL_CONTENT_URI, contentValues)

                if (uri != null) {
                    resolver.openOutputStream(uri)?.use { outputStream ->
                        outputStream.write(audioData)
                    }
                    _error.value = "已保存到下载目录: $filename"
                    addLogStatic("SUCCESS", "音频已保存: $filename")
                } else {
                    _error.value = "保存失败: 无法创建文件"
                    addLogStatic("ERROR", "保存失败: MediaStore 返回 null")
                }
            } catch (e: Exception) {
                _error.value = "下载失败: ${e.message}"
                addLogStatic("ERROR", "保存失败: ${e.message}")
            }
        }
    }

    /**
     * 使用 Android MediaExtractor + MediaCodec 将任意音频格式转码为 WAV (PCM 16bit)
     */
    private fun convertToWav(context: android.content.Context, uri: android.net.Uri): ByteArray {
        val extractor = android.media.MediaExtractor()
        // 使用 FileDescriptor 方式，兼容 API 26+
        context.contentResolver.openFileDescriptor(uri, "r")?.use { pfd ->
            extractor.setDataSource(pfd.fileDescriptor)
        } ?: throw Exception("无法打开音频文件")

        // 找到音频轨道
        var audioTrackIndex = -1
        var mediaFormat: android.media.MediaFormat? = null
        for (i in 0 until extractor.trackCount) {
            val format = extractor.getTrackFormat(i)
            val mime = format.getString(android.media.MediaFormat.KEY_MIME) ?: ""
            if (mime.startsWith("audio/")) {
                audioTrackIndex = i
                mediaFormat = format
                break
            }
        }

        if (audioTrackIndex == -1 || mediaFormat == null) {
            extractor.release()
            throw Exception("未找到音频轨道")
        }

        extractor.selectTrack(audioTrackIndex)

        val sampleRate = mediaFormat.getInteger(android.media.MediaFormat.KEY_SAMPLE_RATE)
        val channels = if (mediaFormat.containsKey(android.media.MediaFormat.KEY_CHANNEL_COUNT))
            mediaFormat.getInteger(android.media.MediaFormat.KEY_CHANNEL_COUNT) else 1

        // 创建解码器
        val decoder = android.media.MediaCodec.createDecoderByType(
            mediaFormat.getString(android.media.MediaFormat.KEY_MIME)!!
        )
        decoder.configure(mediaFormat, null, null, 0)
        decoder.start()

        // 收集所有 PCM 数据
        val pcmData = java.io.ByteArrayOutputStream()
        val bufferInfo = android.media.MediaCodec.BufferInfo()
        val inputBuffer = ByteBuffer.allocate(8192)
        val timeoutUs = 10000L

        while (true) {
            val inputBufferIndex = decoder.dequeueInputBuffer(timeoutUs)
            if (inputBufferIndex >= 0) {
                inputBuffer.clear()
                val sampleSize = extractor.readSampleData(inputBuffer, 0)
                if (sampleSize < 0) {
                    decoder.queueInputBuffer(inputBufferIndex, 0, 0, 0, android.media.MediaCodec.BUFFER_FLAG_END_OF_STREAM)
                    break
                } else {
                    decoder.queueInputBuffer(inputBufferIndex, 0, sampleSize, extractor.sampleTime, 0)
                    extractor.advance()
                }
            }

            val outputBufferIndex = decoder.dequeueOutputBuffer(bufferInfo, timeoutUs)
            if (outputBufferIndex >= 0) {
                val outputBuffer = decoder.getOutputBuffer(outputBufferIndex)
                if (outputBuffer != null && bufferInfo.size > 0) {
                    val outBytes = ByteArray(bufferInfo.size)
                    outputBuffer.get(outBytes)
                    pcmData.write(outBytes)
                }
                decoder.releaseOutputBuffer(outputBufferIndex, false)
                if (bufferInfo.flags and android.media.MediaCodec.BUFFER_FLAG_END_OF_STREAM != 0) break
            }
        }

        decoder.stop()
        decoder.release()
        extractor.release()

        // 构建 WAV 文件头
        val pcmBytes = pcmData.toByteArray()
        return writeWavHeader(pcmBytes, sampleRate, channels)
    }

    /**
     * 写入 WAV 文件头
     */
    private fun writeWavHeader(pcmData: ByteArray, sampleRate: Int, channels: Int): ByteArray {
        val bitsPerSample = 16
        val byteRate = sampleRate * channels * bitsPerSample / 8
        val blockAlign = channels * bitsPerSample / 8
        val dataSize = pcmData.size

        val header = ByteBuffer.allocate(44)
        header.order(java.nio.ByteOrder.LITTLE_ENDIAN)

        // RIFF header
        header.put("RIFF".toByteArray())
        header.putInt(36 + dataSize)
        header.put("WAVE".toByteArray())

        // fmt chunk
        header.put("fmt ".toByteArray())
        header.putInt(16) // chunk size
        header.putShort(1.toShort()) // PCM format
        header.putShort(channels.toShort())
        header.putInt(sampleRate)
        header.putInt(byteRate)
        header.putShort(blockAlign.toShort())
        header.putShort(bitsPerSample.toShort())

        // data chunk
        header.put("data".toByteArray())
        header.putInt(dataSize)

        return header.array() + pcmData
    }
}
