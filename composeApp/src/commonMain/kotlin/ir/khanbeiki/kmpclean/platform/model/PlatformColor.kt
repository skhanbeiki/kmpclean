package ir.khanbeiki.kmpclean.platform.model

import kotlinx.serialization.Serializable

@Serializable
data class PlatformColor(
    val primary: String = "0xFF000000",
    val background: String = "0xFFFFFFFF",
    val textPrimary: String = "0xFF000000"
)
