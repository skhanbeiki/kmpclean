package ir.khanbeiki.kmpclean.core.data.di

import ir.khanbeiki.kmpclean.core.data.datasource.local.preferences.IosPreferenceStorage
import ir.khanbeiki.kmpclean.core.data.datasource.local.preferences.PreferenceStorage
import org.koin.dsl.module

actual val platformDataModule = module {
    single<PreferenceStorage> { IosPreferenceStorage() }
}
