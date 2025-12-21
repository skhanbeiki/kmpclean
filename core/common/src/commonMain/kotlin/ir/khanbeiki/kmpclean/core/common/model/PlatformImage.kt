package ir.khanbeiki.kmpclean.core.common.model

import kotlinx.serialization.Serializable

@Serializable
data class PlatformImage(
    val logo: String = "",
    val background: String = ""
)
