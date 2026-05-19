package com.xiaozhanqi.mimpackage com.xiaozhanqi.mimotts.data.datastore

import android.content.Context
import androidx.datastore.core.DataStore
package com.xiaozhanqi.mimotts.data.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
package com.xiaozhanqi.mimotts.data.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKeypackage com.xiaozhanqi.mimotts.data.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
package com.xiaozhanqi.mimotts.data.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencespackage com.xiaozhanqi.mimotts.data.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.xiaozhanqipackage com.xiaozhanqi.mimotts.data.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.xiaozhanqi.mimotts.data.model.AudioFormat
import com.xiaozhanqi.mimottspackage com.xiaozhanqi.mimotts.data.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.xiaozhanqi.mimotts.data.model.AudioFormat
import com.xiaozhanqi.mimotts.data.model.DarkMode
import com.xiaozhanqi.mimotts.data.model.DEFAULTpackage com.xiaozhanqi.mimotts.data.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.xiaozhanqi.mimotts.data.model.AudioFormat
import com.xiaozhanqi.mimotts.data.model.DarkMode
import com.xiaozhanqi.mimotts.data.model.DEFAULT_PROVIDERS
import com.xiaozhanqi.mimotts.data.model.Settings
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.mappackage com.xiaozhanqi.mimotts.data.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.xiaozhanqi.mimotts.data.model.AudioFormat
import com.xiaozhanqi.mimotts.data.model.DarkMode
import com.xiaozhanqi.mimotts.data.model.DEFAULT_PROVIDERS
import com.xiaozhanqi.mimotts.data.model.Settings
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlin.uuid.Uuid
package com.xiaozhanqi.mimotts.data.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.xiaozhanqi.mimotts.data.model.AudioFormat
import com.xiaozhanqi.mimotts.data.model.DarkMode
import com.xiaozhanqi.mimotts.data.model.DEFAULT_PROVIDERS
import com.xiaozhanqi.mimotts.data.model.Settings
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlin.uuid.Uuid

private val Context.dataStore: DataStore<package com.xiaozhanqi.mimotts.data.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.xiaozhanqi.mimotts.data.model.AudioFormat
import com.xiaozhanqi.mimotts.data.model.DarkMode
import com.xiaozhanqi.mimotts.data.model.DEFAULT_PROVIDERS
import com.xiaozhanqi.mimotts.data.model.Settings
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlin.uuid.Uuid

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class SettingsStore(private val context:package com.xiaozhanqi.mimotts.data.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.xiaozhanqi.mimotts.data.model.AudioFormat
import com.xiaozhanqi.mimotts.data.model.DarkMode
import com.xiaozhanqi.mimotts.data.model.DEFAULT_PROVIDERS
import com.xiaozhanqi.mimotts.data.model.Settings
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlin.uuid.Uuid

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class SettingsStore(private val context: Context) {

    private val json = Json { ignoreUnknownKeys = true }

package com.xiaozhanqi.mimotts.data.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.xiaozhanqi.mimotts.data.model.AudioFormat
import com.xiaozhanqi.mimotts.data.model.DarkMode
import com.xiaozhanqi.mimotts.data.model.DEFAULT_PROVIDERS
import com.xiaozhanqi.mimotts.data.model.Settings
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlin.uuid.Uuid

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class SettingsStore(private val context: Context) {

    private val json = Json { ignoreUnknownKeys = true }

    companion object {
        private val DYNAMIC_COLOR = booleanPreferencesKey("dynamic_color")
package com.xiaozhanqi.mimotts.data.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.xiaozhanqi.mimotts.data.model.AudioFormat
import com.xiaozhanqi.mimotts.data.model.DarkMode
import com.xiaozhanqi.mimotts.data.model.DEFAULT_PROVIDERS
import com.xiaozhanqi.mimotts.data.model.Settings
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlin.uuid.Uuid

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class SettingsStore(private val context: Context) {

    private val json = Json { ignoreUnknownKeys = true }

    companion object {
        private val DYNAMIC_COLOR = booleanPreferencesKey("dynamic_color")
        private val DARK_MODE = stringPreferencesKey("dark_mode")
        private val AMOpackage com.xiaozhanqi.mimotts.data.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.xiaozhanqi.mimotts.data.model.AudioFormat
import com.xiaozhanqi.mimotts.data.model.DarkMode
import com.xiaozhanqi.mimotts.data.model.DEFAULT_PROVIDERS
import com.xiaozhanqi.mimotts.data.model.Settings
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlin.uuid.Uuid

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class SettingsStore(private val context: Context) {

    private val json = Json { ignoreUnknownKeys = true }

    companion object {
        private val DYNAMIC_COLOR = booleanPreferencesKey("dynamic_color")
        private val DARK_MODE = stringPreferencesKey("dark_mode")
        private val AMOLED_DARK = booleanPreferencesKey("amoled_dark")
        private val PROVIDERS = stringpackage com.xiaozhanqi.mimotts.data.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.xiaozhanqi.mimotts.data.model.AudioFormat
import com.xiaozhanqi.mimotts.data.model.DarkMode
import com.xiaozhanqi.mimotts.data.model.DEFAULT_PROVIDERS
import com.xiaozhanqi.mimotts.data.model.Settings
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlin.uuid.Uuid

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class SettingsStore(private val context: Context) {

    private val json = Json { ignoreUnknownKeys = true }

    companion object {
        private val DYNAMIC_COLOR = booleanPreferencesKey("dynamic_color")
        private val DARK_MODE = stringPreferencesKey("dark_mode")
        private val AMOLED_DARK = booleanPreferencesKey("amoled_dark")
        private val PROVIDERS = stringPreferencesKey("providers")
        private val SELECTpackage com.xiaozhanqi.mimotts.data.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.xiaozhanqi.mimotts.data.model.AudioFormat
import com.xiaozhanqi.mimotts.data.model.DarkMode
import com.xiaozhanqi.mimotts.data.model.DEFAULT_PROVIDERS
import com.xiaozhanqi.mimotts.data.model.Settings
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlin.uuid.Uuid

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class SettingsStore(private val context: Context) {

    private val json = Json { ignoreUnknownKeys = true }

    companion object {
        private val DYNAMIC_COLOR = booleanPreferencesKey("dynamic_color")
        private val DARK_MODE = stringPreferencesKey("dark_mode")
        private val AMOLED_DARK = booleanPreferencesKey("amoled_dark")
        private val PROVIDERS = stringPreferencesKey("providers")
        private val SELECTED_PROVIDER_ID = stringPreferencesKey("selected_provider_id")
        private val SELECTED_MODEL_ID = stringPreferencesKey("selected_model_id")
package com.xiaozhanqi.mimotts.data.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.xiaozhanqi.mimotts.data.model.AudioFormat
import com.xiaozhanqi.mimotts.data.model.DarkMode
import com.xiaozhanqi.mimotts.data.model.DEFAULT_PROVIDERS
import com.xiaozhanqi.mimotts.data.model.Settings
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlin.uuid.Uuid

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class SettingsStore(private val context: Context) {

    private val json = Json { ignoreUnknownKeys = true }

    companion object {
        private val DYNAMIC_COLOR = booleanPreferencesKey("dynamic_color")
        private val DARK_MODE = stringPreferencesKey("dark_mode")
        private val AMOLED_DARK = booleanPreferencesKey("amoled_dark")
        private val PROVIDERS = stringPreferencesKey("providers")
        private val SELECTED_PROVIDER_ID = stringPreferencesKey("selected_provider_id")
        private val SELECTED_MODEL_ID = stringPreferencesKey("selected_model_id")
        private val SELECTED_VOICE_ID = stringPreferencesKey("selected_voice_id")
        private valpackage com.xiaozhanqi.mimotts.data.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.xiaozhanqi.mimotts.data.model.AudioFormat
import com.xiaozhanqi.mimotts.data.model.DarkMode
import com.xiaozhanqi.mimotts.data.model.DEFAULT_PROVIDERS
import com.xiaozhanqi.mimotts.data.model.Settings
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlin.uuid.Uuid

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class SettingsStore(private val context: Context) {

    private val json = Json { ignoreUnknownKeys = true }

    companion object {
        private val DYNAMIC_COLOR = booleanPreferencesKey("dynamic_color")
        private val DARK_MODE = stringPreferencesKey("dark_mode")
        private val AMOLED_DARK = booleanPreferencesKey("amoled_dark")
        private val PROVIDERS = stringPreferencesKey("providers")
        private val SELECTED_PROVIDER_ID = stringPreferencesKey("selected_provider_id")
        private val SELECTED_MODEL_ID = stringPreferencesKey("selected_model_id")
        private val SELECTED_VOICE_ID = stringPreferencesKey("selected_voice_id")
        private val AUDIO_FORMAT = stringPreferencesKey("audio_format")
        private val VOICE_DESCRIPTION = stringPreferencespackage com.xiaozhanqi.mimotts.data.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.xiaozhanqi.mimotts.data.model.AudioFormat
import com.xiaozhanqi.mimotts.data.model.DarkMode
import com.xiaozhanqi.mimotts.data.model.DEFAULT_PROVIDERS
import com.xiaozhanqi.mimotts.data.model.Settings
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlin.uuid.Uuid

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class SettingsStore(private val context: Context) {

    private val json = Json { ignoreUnknownKeys = true }

    companion object {
        private val DYNAMIC_COLOR = booleanPreferencesKey("dynamic_color")
        private val DARK_MODE = stringPreferencesKey("dark_mode")
        private val AMOLED_DARK = booleanPreferencesKey("amoled_dark")
        private val PROVIDERS = stringPreferencesKey("providers")
        private val SELECTED_PROVIDER_ID = stringPreferencesKey("selected_provider_id")
        private val SELECTED_MODEL_ID = stringPreferencesKey("selected_model_id")
        private val SELECTED_VOICE_ID = stringPreferencesKey("selected_voice_id")
        private val AUDIO_FORMAT = stringPreferencesKey("audio_format")
        private val VOICE_DESCRIPTION = stringPreferencesKey("voice_description")
        private val DEFAULTpackage com.xiaozhanqi.mimotts.data.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.xiaozhanqi.mimotts.data.model.AudioFormat
import com.xiaozhanqi.mimotts.data.model.DarkMode
import com.xiaozhanqi.mimotts.data.model.DEFAULT_PROVIDERS
import com.xiaozhanqi.mimotts.data.model.Settings
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlin.uuid.Uuid

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class SettingsStore(private val context: Context) {

    private val json = Json { ignoreUnknownKeys = true }

    companion object {
        private val DYNAMIC_COLOR = booleanPreferencesKey("dynamic_color")
        private val DARK_MODE = stringPreferencesKey("dark_mode")
        private val AMOLED_DARK = booleanPreferencesKey("amoled_dark")
        private val PROVIDERS = stringPreferencesKey("providers")
        private val SELECTED_PROVIDER_ID = stringPreferencesKey("selected_provider_id")
        private val SELECTED_MODEL_ID = stringPreferencesKey("selected_model_id")
        private val SELECTED_VOICE_ID = stringPreferencesKey("selected_voice_id")
        private val AUDIO_FORMAT = stringPreferencesKey("audio_format")
        private val VOICE_DESCRIPTION = stringPreferencesKey("voice_description")
        private val DEFAULT_STYLE_INSTRUCTION = stringPreferencesKey("default_style_instructionpackage com.xiaozhanqi.mimotts.data.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.xiaozhanqi.mimotts.data.model.AudioFormat
import com.xiaozhanqi.mimotts.data.model.DarkMode
import com.xiaozhanqi.mimotts.data.model.DEFAULT_PROVIDERS
import com.xiaozhanqi.mimotts.data.model.Settings
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlin.uuid.Uuid

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class SettingsStore(private val context: Context) {

    private val json = Json { ignoreUnknownKeys = true }

    companion object {
        private val DYNAMIC_COLOR = booleanPreferencesKey("dynamic_color")
        private val DARK_MODE = stringPreferencesKey("dark_mode")
        private val AMOLED_DARK = booleanPreferencesKey("amoled_dark")
        private val PROVIDERS = stringPreferencesKey("providers")
        private val SELECTED_PROVIDER_ID = stringPreferencesKey("selected_provider_id")
        private val SELECTED_MODEL_ID = stringPreferencesKey("selected_model_id")
        private val SELECTED_VOICE_ID = stringPreferencesKey("selected_voice_id")
        private val AUDIO_FORMAT = stringPreferencesKey("audio_format")
        private val VOICE_DESCRIPTION = stringPreferencesKey("voice_description")
        private val DEFAULT_STYLE_INSTRUCTION = stringPreferencesKey("default_style_instruction")
        private val RECENT_TEXTS = stringPreferencesKey("recent_texts")
package com.xiaozhanqi.mimotts.data.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.xiaozhanqi.mimotts.data.model.AudioFormat
import com.xiaozhanqi.mimotts.data.model.DarkMode
import com.xiaozhanqi.mimotts.data.model.DEFAULT_PROVIDERS
import com.xiaozhanqi.mimotts.data.model.Settings
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlin.uuid.Uuid

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class SettingsStore(private val context: Context) {

    private val json = Json { ignoreUnknownKeys = true }

    companion object {
        private val DYNAMIC_COLOR = booleanPreferencesKey("dynamic_color")
        private val DARK_MODE = stringPreferencesKey("dark_mode")
        private val AMOLED_DARK = booleanPreferencesKey("amoled_dark")
        private val PROVIDERS = stringPreferencesKey("providers")
        private val SELECTED_PROVIDER_ID = stringPreferencesKey("selected_provider_id")
        private val SELECTED_MODEL_ID = stringPreferencesKey("selected_model_id")
        private val SELECTED_VOICE_ID = stringPreferencesKey("selected_voice_id")
        private val AUDIO_FORMAT = stringPreferencesKey("audio_format")
        private val VOICE_DESCRIPTION = stringPreferencesKey("voice_description")
        private val DEFAULT_STYLE_INSTRUCTION = stringPreferencesKey("default_style_instruction")
        private val RECENT_TEXTS = stringPreferencesKey("recent_texts")
    }

    val settings: Flow<Settings> = context.dataStore.data.map { preferences ->