package ir.khanbeiki.kmpclean.platform

import ir.khanbeiki.kmpclean.BuildConfig
import ir.khanbeiki.kmpclean.core.base.ProjectConfig
import ir.khanbeiki.kmpclean.core.common.model.MarketName
import ir.khanbeiki.kmpclean.core.common.model.PlatformData
import ir.khanbeiki.kmpclean.core.common.model.PlatformType

fun androidPlatform(): PlatformData {
    val platform: PlatformType = PlatformType.Android
    var name = ""
    var applicationName = ""
    var baseUrl = ""
    var marketName = MarketName.Unknown

    val cafebazaar = "Cafebazaar"
    val myket = "Myket"
    val playstore = "Playstore"

    // Determine Market
    if (BuildConfig.FLAVOR.contains(cafebazaar, ignoreCase = true)) {
        marketName = MarketName.Cafebazaar
    } else if (BuildConfig.FLAVOR.contains(myket, ignoreCase = true)) {
        marketName = MarketName.Myket
    } else if (BuildConfig.FLAVOR.contains(playstore, ignoreCase = true)) {
        marketName = MarketName.Playstore
    }

    // Determine App
    when {
        BuildConfig.FLAVOR.contains("water", ignoreCase = true) -> {
            name = "water"
            applicationName = "Water Bill Inquiry"
        }
        BuildConfig.FLAVOR.contains("electricity", ignoreCase = true) -> {
            name = "electricity"
            applicationName = "Electricity Bill Inquiry"
        }
        BuildConfig.FLAVOR.contains("gas", ignoreCase = true) -> {
            name = "gas"
            applicationName = "Gas Bill Inquiry"
        }
        BuildConfig.FLAVOR.contains("phone", ignoreCase = true) -> {
            name = "phone"
            applicationName = "Phone Bill Inquiry"
        }
        BuildConfig.FLAVOR.contains("mobile", ignoreCase = true) -> {
            name = "mobile"
            applicationName = "Mobile Bill Inquiry"
        }
    }

    // Determine Base URL (Mock for now)
    baseUrl = "https://api.example.com/"

    return PlatformData(
        platform = platform,
        marketName = marketName,
        name = name,
        applicationName = applicationName,
        baseUrl = baseUrl
    )
}

actual fun getPlatform() = androidPlatform()

import androidx.compose.ui.graphics.Color

actual fun getProjectConfig(): ProjectConfig {
    return object : ProjectConfig {
        override val appName: String = BuildConfig.APP_NAME
        override val baseUrl: String = BuildConfig.BASE_URL
        override val marketName: String = BuildConfig.MARKET_NAME
        override val primaryColor: Color = Color(java.lang.Long.decode(BuildConfig.PRIMARY_COLOR))
        override val backgroundColor: Color = Color(java.lang.Long.decode(BuildConfig.BACKGROUND_COLOR))
        override val textPrimaryColor: Color = Color(java.lang.Long.decode(BuildConfig.TEXT_PRIMARY_COLOR))
        override val titleFa: String = BuildConfig.TITLE_FA
        override val titleEn: String = BuildConfig.TITLE_EN
        override val descriptionFa: String = BuildConfig.DESCRIPTION_FA
        override val descriptionEn: String = BuildConfig.DESCRIPTION_EN
        override val logoRes: String = BuildConfig.LOGO_RES
    }
}
