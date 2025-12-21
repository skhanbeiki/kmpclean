package ir.khanbeiki.kmpclean.di

import ir.khanbeiki.kmpclean.core.data.di.dataModule
import ir.khanbeiki.kmpclean.core.domain.di.domainModule
import ir.khanbeiki.kmpclean.feature.inquiry.di.inquiryModule
import ir.khanbeiki.kmpclean.feature.payment.di.paymentModule
import ir.khanbeiki.kmpclean.feature.registration.di.registrationModule
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun initKoin(appDeclaration: KoinAppDeclaration = {}) = startKoin {
    appDeclaration()
    modules(
        dataModule,
        domainModule,
        presentationModule,
        inquiryModule,
        paymentModule,
        registrationModule
    )
}
