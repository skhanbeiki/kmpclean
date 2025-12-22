package ir.khanbeiki.kmpclean.platform

import ir.khanbeiki.kmpclean.core.base.ProjectConfig
import ir.khanbeiki.kmpclean.core.common.model.LanguageStrings
import ir.khanbeiki.kmpclean.core.common.model.MarketName
import ir.khanbeiki.kmpclean.library.designsystem.theme.AppColors
import ir.khanbeiki.kmpclean.library.designsystem.theme.AppImages
import ir.khanbeiki.kmpclean.library.designsystem.theme.AppStrings

class ConfigProject(private val projectConfig: ProjectConfig) {
    fun getConfigProject() {
        BaseData.marketName = try {
            MarketName.valueOf(projectConfig.marketName)
        } catch (e: Exception) {
            MarketName.Unknown
        }
        BaseData.applicationName = projectConfig.appName
        BaseData.baseUrl = projectConfig.baseUrl

        AppColors.primary = projectConfig.primaryColor
        AppColors.background = projectConfig.backgroundColor
        AppColors.textPrimary = projectConfig.textPrimaryColor

        AppStrings.title = LanguageStrings(fa = projectConfig.titleFa, en = projectConfig.titleEn)
        AppStrings.description = LanguageStrings(fa = projectConfig.descriptionFa, en = projectConfig.descriptionEn)

        AppImages.logo(projectConfig.logoRes)
    }
}
