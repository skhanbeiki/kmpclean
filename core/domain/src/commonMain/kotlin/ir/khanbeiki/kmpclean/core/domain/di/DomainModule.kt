package ir.khanbeiki.kmpclean.core.domain.di

import ir.khanbeiki.kmpclean.core.domain.usecase.InquireUseCase
import ir.khanbeiki.kmpclean.core.domain.usecase.PayUseCase
import ir.khanbeiki.kmpclean.core.domain.usecase.RegisterUseCase
import org.koin.dsl.module

val domainModule = module {
    factory { RegisterUseCase(get()) }
    factory { PayUseCase(get()) }
    factory { InquireUseCase(get()) }
}
