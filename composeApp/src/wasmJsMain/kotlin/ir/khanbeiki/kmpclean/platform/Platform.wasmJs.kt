package ir.khanbeiki.kmpclean.platform

import io.ktor.util.Platform
import ir.khanbeiki.kmpclean.core.common.model.MarketName
import ir.khanbeiki.kmpclean.core.common.model.PlatformData
import ir.khanbeiki.kmpclean.core.common.model.PlatformType


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