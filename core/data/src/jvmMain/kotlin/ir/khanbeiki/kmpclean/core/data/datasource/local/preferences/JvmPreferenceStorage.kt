package ir.khanbeiki.kmpclean.core.data.datasource.local.preferences

import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import java.io.File

class JvmPreferenceStorage : PreferenceStorage {
    
    private val dataStore = PreferenceDataStoreFactory.create {
        File("app_prefs.preferences_pb")
    }

    override suspend fun saveString(key: String, value: String) {
        val prefKey = stringPreferencesKey(key)
        dataStore.edit { prefs ->
            prefs[prefKey] = value
        }
    }

    override suspend fun readString(key: String): String? {
        val prefKey = stringPreferencesKey(key)
        return dataStore.data.map { prefs -> prefs[prefKey] }.first()
    }

    override suspend fun saveBoolean(key: String, value: Boolean) {
        val prefKey = booleanPreferencesKey(key)
        dataStore.edit { prefs ->
            prefs[prefKey] = value
        }
    }

    override suspend fun readBoolean(key: String): Boolean? {
        val prefKey = booleanPreferencesKey(key)
        return dataStore.data.map { prefs -> prefs[prefKey] }.first()
    }
}
