package ir.khanbeiki.kmpclean.platform

import ir.khanbeiki.kmpclean.core.common.model.ConfigData
import ir.khanbeiki.kmpclean.library.designsystem.theme.AppColors
import ir.khanbeiki.kmpclean.library.designsystem.theme.AppImages
import ir.khanbeiki.kmpclean.library.designsystem.theme.AppStrings
import ir.khanbeiki.kmpclean.library.designsystem.util.loadJsonFile
import kotlinx.serialization.json.Json
import androidx.compose.ui.graphics.Color

class ConfigProject {
    suspend fun getConfigProject(): ConfigData {
        val platform = getPlatform()
        BaseData.platform = platform.platform
        BaseData.marketName = platform.marketName
        BaseData.name = platform.name
        BaseData.applicationName = platform.applicationName
        BaseData.baseUrl = platform.baseUrl

        val configJson = Json {
            ignoreUnknownKeys = true
        }
        val config = configJson.decodeFromString<ConfigData>(loadJsonFile(platform.name))

        AppColors.primary = Color(config.colors.primary.removePrefix("0x").toLong(16))
        AppColors.background = Color(config.colors.background.removePrefix("0x").toLong(16))
        AppColors.textPrimary = Color(config.colors.textPrimary.removePrefix("0x").toLong(16))

        AppStrings.title = config.strings.title
        AppStrings.description = config.strings.description

        AppImages.logo(config.images.logo)

        return config
    }
}
