package com.mimotts.android.data.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.mimotts.android.data.model.ApiMode
import com.mimotts.android.data.model.AudioFormat
import com.mimotts.android.data.model.TTSModel
import com.mimotts.android.data.model.TTSSettings
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
    
    suspend fun updateApiMode(apiMode: ApiMode) {
        context.dataStore.edit { preferences ->
            val current = preferences[TTS_SETTINGS_KEY]?.let { 
                Json.decodeFromString<TTSSettings>(it) 
            } ?: TTSSettings()
            preferences[TTS_SETTINGS_KEY] = Json.encodeToString(
                current.copy(apiMode = apiMode)
            )
        }
    }
    
    suspend fun updatePlanToken(token: String) {
        context.dataStore.edit { preferences ->
            val current = preferences[TTS_SETTINGS_KEY]?.let { 
                Json.decodeFromString<TTSSettings>(it) 
            } ?: TTSSettings()
            preferences[TTS_SETTINGS_KEY] = Json.encodeToString(
                current.copy(planToken = token)
            )
        }
    }
    
    suspend fun updateApiKey(apiKey: String) {
        context.dataStore.edit { preferences ->
            val current = preferences[TTS_SETTINGS_KEY]?.let { 
                Json.decodeFromString<TTSSettings>(it) 
            } ?: TTSSettings()
            preferences[TTS_SETTINGS_KEY] = Json.encodeToString(
                current.copy(apiKey = apiKey)
            )
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
}
