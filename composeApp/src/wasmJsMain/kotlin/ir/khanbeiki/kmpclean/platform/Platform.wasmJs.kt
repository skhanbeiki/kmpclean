package ir.khanbeiki.kmpclean.platform

import ir.khanbeiki.kmpclean.core.base.ProjectConfig
import ir.khanbeiki.kmpclean.core.common.model.MarketName
import ir.khanbeiki.kmpclean.core.common.model.PlatformData
import ir.khanbeiki.kmpclean.core.common.model.PlatformType
import ir.khanbeiki.kmpclean.platform.config.ActualProjectConfig


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

actual fun getProjectConfig(): ProjectConfig {
    return ActualProjectConfig
}