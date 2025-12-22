package ir.khanbeiki.kmpclean.di

import ir.khanbeiki.kmpclean.platform.ConfigProject
import ir.khanbeiki.kmpclean.AppViewModel
import ir.khanbeiki.kmpclean.core.base.ProjectConfig
import ir.khanbeiki.kmpclean.library.navigation.NavigationProvider
import ir.khanbeiki.kmpclean.navigation.NavigationProviderImpl
import ir.khanbeiki.kmpclean.platform.getProjectConfig
import org.koin.dsl.module

val presentationModule = module {
    single<ProjectConfig> {
        // This will be resolved per-platform (Android/Desktop)
        getProjectConfig()
    }
    single { ConfigProject(get()) }
    factory { AppViewModel(get()) }
    single<NavigationProvider> { NavigationProviderImpl() }
}
