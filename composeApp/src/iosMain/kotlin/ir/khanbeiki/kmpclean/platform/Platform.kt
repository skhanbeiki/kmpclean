package ir.khanbeiki.kmpclean.platform

import ir.khanbeiki.kmpclean.core.common.model.MarketName
import ir.khanbeiki.kmpclean.core.common.model.PlatformData
import ir.khanbeiki.kmpclean.core.common.model.PlatformType

fun iosPlatform(): PlatformData {
    return PlatformData(
        platform = PlatformType.iOS,
        marketName = MarketName.AppStore,
        name = "water", // Default to water for now on iOS
        applicationName = "Water Bill Inquiry",
        baseUrl = "https://api.example.com/"
    )
}

actual fun getPlatform() = iosPlatform()
