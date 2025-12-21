package ir.khanbeiki.kmpclean.di

import ir.khanbeiki.kmpclean.platform.ConfigProject
import ir.khanbeiki.kmpclean.AppViewModel
import ir.khanbeiki.kmpclean.library.navigation.NavigationProvider
import ir.khanbeiki.kmpclean.navigation.NavigationProviderImpl
import org.koin.dsl.module

val presentationModule = module {
    single { ConfigProject() }
    factory { AppViewModel(get()) }
    single<NavigationProvider> { NavigationProviderImpl() }
}
