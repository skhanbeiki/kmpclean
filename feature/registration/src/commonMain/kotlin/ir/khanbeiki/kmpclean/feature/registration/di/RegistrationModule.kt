package ir.khanbeiki.kmpclean.feature.registration.di

import ir.khanbeiki.kmpclean.feature.registration.RegistrationViewModel
import org.koin.dsl.module

val registrationModule = module {
    factory { RegistrationViewModel(get()) }
}
