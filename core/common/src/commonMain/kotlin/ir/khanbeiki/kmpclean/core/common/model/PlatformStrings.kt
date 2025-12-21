package ir.khanbeiki.kmpclean.core.common.model

import kotlinx.serialization.Serializable

@Serializable
data class PlatformStrings(
    val title: LanguageStrings = LanguageStrings(),
    val description: LanguageStrings = LanguageStrings()
)
