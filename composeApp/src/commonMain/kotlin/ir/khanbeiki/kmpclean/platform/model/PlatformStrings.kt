package ir.khanbeiki.kmpclean.platform.model

import kotlinx.serialization.Serializable

@Serializable
data class PlatformStrings(
    val title: LanguageStrings = LanguageStrings(),
    val description: LanguageStrings = LanguageStrings()
)
