package ir.khanbeiki.kmpclean.platform

import ir.khanbeiki.kmpclean.platform.model.MarketName
import ir.khanbeiki.kmpclean.platform.model.PlatformData
import ir.khanbeiki.kmpclean.platform.model.PlatformType


fun jsPlatform(): PlatformData {
    return PlatformData(
        platform = PlatformType.Web,
        marketName = MarketName.Unknown,
        name = "water",
        applicationName = "Water Bill Inquiry",
        baseUrl = "https://api.example.com/"
    )
}


actual fun getPlatform()  = jsPlatform()