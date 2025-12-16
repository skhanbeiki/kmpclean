package ir.khanbeiki.kmpclean.platform

import ir.khanbeiki.kmpclean.platform.model.MarketName
import ir.khanbeiki.kmpclean.platform.model.PlatformType

object BaseData {
    var platform: PlatformType = PlatformType.Android
    var marketName: MarketName = MarketName.Cafebazaar
    var name: String = ""
    var applicationName: String = ""
    var baseUrl: String = ""
}
