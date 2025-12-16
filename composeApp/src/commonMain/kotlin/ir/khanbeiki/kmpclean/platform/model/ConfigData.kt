package ir.khanbeiki.kmpclean.platform.model

import kotlinx.serialization.Serializable

@Serializable
data class ConfigData(
    val colors: PlatformColor = PlatformColor(),
    val strings: PlatformStrings = PlatformStrings(),
    val images: PlatformImage = PlatformImage()
)
