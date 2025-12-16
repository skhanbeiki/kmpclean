package ir.khanbeiki.kmpclean.platform

import io.ktor.util.Platform
import ir.khanbeiki.kmpclean.platform.model.MarketName
import ir.khanbeiki.kmpclean.platform.model.PlatformData
import ir.khanbeiki.kmpclean.platform.model.PlatformType


fun wasmPlatform(): PlatformData {
    return PlatformData(
        platform = PlatformType.Web,
        marketName = MarketName.Unknown,
        name = "water", // Default to water for now on Desktop
        applicationName = "Water Bill Inquiry",
        baseUrl = "https://api.example.com/"
    )
}


actual fun getPlatform()  = wasmPlatform()