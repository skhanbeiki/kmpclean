package ir.khanbeiki.kmpclean.core.base

import androidx.compose.ui.graphics.Color

interface ProjectConfig {
    val appName: String
    val baseUrl: String
    val marketName: String
    val primaryColorHex: String
    val backgroundColorHex: String
    val textPrimaryColorHex: String
    val titleFa: String
    val titleEn: String
    val descriptionFa: String
    val descriptionEn: String
    val logoRes: String

    // Helper properties to convert Hex to Color
    val primaryColor: Color get() = Color(primaryColorHex.removePrefix("0x").toLong(16))
    val backgroundColor: Color get() = Color(backgroundColorHex.removePrefix("0x").toLong(16))
    val textPrimaryColor: Color get() = Color(textPrimaryColorHex.removePrefix("0x").toLong(16))
}
