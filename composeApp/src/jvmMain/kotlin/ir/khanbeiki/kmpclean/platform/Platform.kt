package ir.khanbeiki.kmpclean.platform

import ir.khanbeiki.kmpclean.core.base.ProjectConfig
import ir.khanbeiki.kmpclean.core.common.model.MarketName
import ir.khanbeiki.kmpclean.core.common.model.PlatformData
import ir.khanbeiki.kmpclean.core.common.model.PlatformType
import ir.khanbeiki.kmpclean.platform.config.ActualProjectConfig

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

actual fun getProjectConfig(): ProjectConfig {
    return ActualProjectConfig
}
