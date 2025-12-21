package ir.khanbeiki.kmpclean.core.common.util

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

enum class AppLanguage { FA, EN }

object LanguageManager {
    var currentLanguage by mutableStateOf(AppLanguage.EN)
}
