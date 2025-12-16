package ir.khanbeiki.kmpclean.platform.model

import ir.khanbeiki.kmpclean.presentation.ui.util.AppLanguage
import ir.khanbeiki.kmpclean.presentation.ui.util.LanguageManager
import kotlinx.serialization.Serializable

@Serializable
data class LanguageStrings(
    val fa: String = "",
    val en: String = ""
) {
    val current: String
        get() = if (LanguageManager.currentLanguage == AppLanguage.FA) fa else en
}
