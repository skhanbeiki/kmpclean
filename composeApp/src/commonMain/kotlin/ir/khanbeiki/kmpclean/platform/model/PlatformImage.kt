package ir.khanbeiki.kmpclean.platform.model

import kotlinx.serialization.Serializable

@Serializable
data class PlatformImage(
    val logo: String = "",
    val background: String = ""
)
