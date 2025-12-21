package ir.khanbeiki.kmpclean.core.common.model

import ir.khanbeiki.kmpclean.core.common.util.AppLanguage
import ir.khanbeiki.kmpclean.core.common.util.LanguageManager
import kotlinx.serialization.Serializable

@Serializable
data class LanguageStrings(
    val fa: String = "",
    val en: String = ""
) {
    val current: String
        get() = if (LanguageManager.currentLanguage == AppLanguage.FA) fa else en
}
