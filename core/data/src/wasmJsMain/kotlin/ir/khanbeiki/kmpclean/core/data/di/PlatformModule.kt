package ir.khanbeiki.kmpclean.core.data.di

import ir.khanbeiki.kmpclean.core.data.datasource.local.preferences.PreferenceStorage
import ir.khanbeiki.kmpclean.core.data.datasource.local.preferences.WasmJsPreferenceStorage
import org.koin.dsl.module

actual val platformDataModule = module {
    single<PreferenceStorage> { WasmJsPreferenceStorage() }
}
