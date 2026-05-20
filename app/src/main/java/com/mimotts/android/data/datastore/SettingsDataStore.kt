package com.mimotts.android.data.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.mimotts.android.data.model.ApiConfig
import com.mimotts.android.data.model.AudioFormat
import com.mimotts.android.data.model.TTSModel
import com.mimotts.android.data.model.TTSSettings
import com.mimotts.android.data.model.TTSHistoryItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class SettingsDataStore(private val context: Context) {

    private val TTS_SETTINGS_KEY = stringPreferencesKey("tts_settings")

    val settingsFlow: Flow<TTSSettings> = context.dataStore.data
        .map { preferences ->
            preferences[TTS_SETTINGS_KEY]?.let { json ->
                try {
                    Json.decodeFromString<TTSSettings>(json)
                } catch (e: Exception) {
                    TTSSettings()
                }
            } ?: TTSSettings()
        }

    suspend fun updateSettings(settings: TTSSettings) {
        context.dataStore.edit { preferences ->
            preferences[TTS_SETTINGS_KEY] = Json.encodeToString(settings)
        }
    }

    suspend fun updateApiKey(apiKey: String) {
        context.dataStore.edit { preferences ->
            val current = preferences[TTS_SETTINGS_KEY]?.let {
                Json.decodeFromString<TTSSettings>(it)
            } ?: TTSSettings()
            val activeConfig = current.apiConfigs.find { it.id == current.activeApiId }
            if (activeConfig != null) {
                val updatedConfigs = current.apiConfigs.map { config ->
                    if (config.id == current.activeApiId) config.copy(apiKey = apiKey) else config
                }
                preferences[TTS_SETTINGS_KEY] = Json.encodeToString(
                    current.copy(apiConfigs = updatedConfigs)
                )
            } else {
                preferences[TTS_SETTINGS_KEY] = Json.encodeToString(
                    current.copy(apiKey = apiKey)
                )
            }
        }
    }

    suspend fun addApiConfig(config: ApiConfig) {
        context.dataStore.edit { preferences ->
            val current = preferences[TTS_SETTINGS_KEY]?.let {
                Json.decodeFromString<TTSSettings>(it)
            } ?: TTSSettings()
            preferences[TTS_SETTINGS_KEY] = Json.encodeToString(
                current.copy(apiConfigs = current.apiConfigs + config)
            )
        }
    }

    suspend fun removeApiConfig(id: String) {
        context.dataStore.edit { preferences ->
            val current = preferences[TTS_SETTINGS_KEY]?.let {
                Json.decodeFromString<TTSSettings>(it)
            } ?: TTSSettings()
            preferences[TTS_SETTINGS_KEY] = Json.encodeToString(
                current.copy(apiConfigs = current.apiConfigs.filter { it.id != id })
            )
        }
    }

    suspend fun updateApiConfig(config: ApiConfig) {
        context.dataStore.edit { preferences ->
            val current = preferences[TTS_SETTINGS_KEY]?.let {
                Json.decodeFromString<TTSSettings>(it)
            } ?: TTSSettings()
            preferences[TTS_SETTINGS_KEY] = Json.encodeToString(
                current.copy(
                    apiConfigs = current.apiConfigs.map {
                        if (it.id == config.id) config else it
                    }
                )
            )
        }
    }

    suspend fun setActiveApiId(id: String) {
        context.dataStore.edit { preferences ->
            val current = preferences[TTS_SETTINGS_KEY]?.let {
                Json.decodeFromString<TTSSettings>(it)
            } ?: TTSSettings()
            preferences[TTS_SETTINGS_KEY] = Json.encodeToString(
                current.copy(activeApiId = id)
            )
        }
    }

    fun getActiveApiConfig(): Flow<ApiConfig?> {
        return settingsFlow.map { settings ->
            settings.apiConfigs.find { it.id == settings.activeApiId }
        }
    }

    suspend fun updateSelectedModel(model: TTSModel) {
        context.dataStore.edit { preferences ->
            val current = preferences[TTS_SETTINGS_KEY]?.let {
                Json.decodeFromString<TTSSettings>(it)
            } ?: TTSSettings()
            preferences[TTS_SETTINGS_KEY] = Json.encodeToString(
                current.copy(selectedModel = model)
            )
        }
    }

    suspend fun updateSelectedVoice(voice: String) {
        context.dataStore.edit { preferences ->
            val current = preferences[TTS_SETTINGS_KEY]?.let {
                Json.decodeFromString<TTSSettings>(it)
            } ?: TTSSettings()
            preferences[TTS_SETTINGS_KEY] = Json.encodeToString(
                current.copy(selectedVoice = voice)
            )
        }
    }

    suspend fun updateVoiceDescription(description: String) {
        context.dataStore.edit { preferences ->
            val current = preferences[TTS_SETTINGS_KEY]?.let {
                Json.decodeFromString<TTSSettings>(it)
            } ?: TTSSettings()
            preferences[TTS_SETTINGS_KEY] = Json.encodeToString(
                current.copy(voiceDescription = description)
            )
        }
    }

    suspend fun updateAudioFormat(format: AudioFormat) {
        context.dataStore.edit { preferences ->
            val current = preferences[TTS_SETTINGS_KEY]?.let {
                Json.decodeFromString<TTSSettings>(it)
            } ?: TTSSettings()
            preferences[TTS_SETTINGS_KEY] = Json.encodeToString(
                current.copy(audioFormat = format)
            )
        }
    }

    suspend fun updateStyleInstruction(instruction: String) {
        context.dataStore.edit { preferences ->
            val current = preferences[TTS_SETTINGS_KEY]?.let {
                Json.decodeFromString<TTSSettings>(it)
            } ?: TTSSettings()
            preferences[TTS_SETTINGS_KEY] = Json.encodeToString(
                current.copy(styleInstruction = instruction)
            )
        }
    }

    suspend fun updateStyleTags(tags: List<String>) {
        context.dataStore.edit { preferences ->
            val current = preferences[TTS_SETTINGS_KEY]?.let {
                Json.decodeFromString<TTSSettings>(it)
            } ?: TTSSettings()
            preferences[TTS_SETTINGS_KEY] = Json.encodeToString(
                current.copy(styleTags = tags)
            )
        }
    }

    suspend fun addHistoryItem(item: TTSHistoryItem) {
        context.dataStore.edit { preferences ->
            val current = preferences[TTS_SETTINGS_KEY]?.let {
                Json.decodeFromString<TTSSettings>(it)
            } ?: TTSSettings()
            preferences[TTS_SETTINGS_KEY] = Json.encodeToString(
                current.copy(historyItems = listOf(item) + current.historyItems.take(99)) // 最多保存100条
            )
        }
    }

    suspend fun clearHistory() {
        context.dataStore.edit { preferences ->
            val current = preferences[TTS_SETTINGS_KEY]?.let {
                Json.decodeFromString<TTSSettings>(it)
            } ?: TTSSettings()
            preferences[TTS_SETTINGS_KEY] = Json.encodeToString(
                current.copy(historyItems = emptyList())
            )
        }
    }

    suspend fun removeHistoryItem(id: String) {
        context.dataStore.edit { preferences ->
            val current = preferences[TTS_SETTINGS_KEY]?.let {
                Json.decodeFromString<TTSSettings>(it)
            } ?: TTSSettings()
            preferences[TTS_SETTINGS_KEY] = Json.encodeToString(
                current.copy(historyItems = current.historyItems.filter { it.id != id })
            )
        }
    }
}
