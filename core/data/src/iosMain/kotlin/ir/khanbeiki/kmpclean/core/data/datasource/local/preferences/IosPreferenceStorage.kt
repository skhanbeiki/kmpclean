package ir.khanbeiki.kmpclean.core.data.datasource.local.preferences

import platform.Foundation.NSUserDefaults

class IosPreferenceStorage : PreferenceStorage {

    private val defaults: NSUserDefaults = NSUserDefaults.standardUserDefaults

    override suspend fun saveString(key: String, value: String) {
        defaults.setObject(value, forKey = key)
    }

    override suspend fun readString(key: String): String? {
        return defaults.stringForKey(key)
    }

    override suspend fun saveBoolean(key: String, value: Boolean) {
        defaults.setBool(value, forKey = key)
    }

    override suspend fun readBoolean(key: String): Boolean? {
        // NSUserDefaults boolForKey returns NO (false) if key doesn't exist
        // To handle nullability strictly, we might check objectForKey
        return if (defaults.objectForKey(key) != null) {
            defaults.boolForKey(key)
        } else {
            null
        }
    }
}
