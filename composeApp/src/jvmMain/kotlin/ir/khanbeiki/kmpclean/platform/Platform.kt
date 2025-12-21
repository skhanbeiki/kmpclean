package ir.khanbeiki.kmpclean.platform

import ir.khanbeiki.kmpclean.core.common.model.MarketName
import ir.khanbeiki.kmpclean.core.common.model.PlatformData
import ir.khanbeiki.kmpclean.core.common.model.PlatformType

fun jvmPlatform(): PlatformData {
    return PlatformData(
        platform = PlatformType.Desktop,
        marketName = MarketName.Unknown,
        name = "water",
        applicationName = "Water Bill Inquiry",
        baseUrl = "https://api.example.com/"
    )
}

actual fun getPlatform() = jvmPlatform()
