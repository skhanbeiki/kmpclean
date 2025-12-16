package ir.khanbeiki.kmpclean.platform.model

import kotlinx.serialization.Serializable

@Serializable
data class PlatformData(
    val platform: PlatformType = PlatformType.Android,
    val marketName: MarketName = MarketName.Unknown,
    val name: String = "",
    val applicationName: String = "",
    val baseUrl: String = ""
)
