package ir.khanbeiki.kmpclean.platform

import ir.khanbeiki.kmpclean.BuildConfig
import ir.khanbeiki.kmpclean.platform.model.MarketName
import ir.khanbeiki.kmpclean.platform.model.PlatformData
import ir.khanbeiki.kmpclean.platform.model.PlatformType

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
