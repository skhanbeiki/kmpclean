package ir.khanbeiki.kmpclean.core.data.datasource.local.preferences

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

private val Context.dataStore by preferencesDataStore(name = "app_prefs")

class AndroidPreferenceStorage(private val context: Context) : PreferenceStorage {

    override suspend fun saveString(key: String, value: String) {
        val prefKey = stringPreferencesKey(key)
        context.dataStore.edit { prefs ->
            prefs[prefKey] = value
        }
    }

    override suspend fun readString(key: String): String? {
        val prefKey = stringPreferencesKey(key)
        return context.dataStore.data.map { prefs -> prefs[prefKey] }.first()
    }

    override suspend fun saveBoolean(key: String, value: Boolean) {
        val prefKey = booleanPreferencesKey(key)
        context.dataStore.edit { prefs ->
            prefs[prefKey] = value
        }
    }

    override suspend fun readBoolean(key: String): Boolean? {
        val prefKey = booleanPreferencesKey(key)
        return context.dataStore.data.map { prefs -> prefs[prefKey] }.first()
    }
}
