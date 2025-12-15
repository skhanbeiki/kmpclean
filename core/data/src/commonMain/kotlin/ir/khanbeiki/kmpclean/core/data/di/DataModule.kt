package ir.khanbeiki.kmpclean.core.data.di

import ir.khanbeiki.kmpclean.core.data.repository.AuthRepositoryImpl
import ir.khanbeiki.kmpclean.core.data.repository.InquiryRepositoryImpl
import ir.khanbeiki.kmpclean.core.data.repository.PaymentRepositoryImpl
import ir.khanbeiki.kmpclean.core.domain.repository.AuthRepository
import ir.khanbeiki.kmpclean.core.domain.repository.InquiryRepository
import ir.khanbeiki.kmpclean.core.domain.repository.PaymentRepository
import ir.khanbeiki.kmpclean.core.network.KtorClient
import org.koin.dsl.module

val dataModule = module {
    single { KtorClient.httpClient }
    single<AuthRepository> { AuthRepositoryImpl(get()) }
    single<PaymentRepository> { PaymentRepositoryImpl(get()) }
    single<InquiryRepository> { InquiryRepositoryImpl(get()) }
}
