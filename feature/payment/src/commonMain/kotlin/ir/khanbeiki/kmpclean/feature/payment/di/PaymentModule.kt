package ir.khanbeiki.kmpclean.feature.payment.di

import ir.khanbeiki.kmpclean.feature.payment.PaymentViewModel
import org.koin.dsl.module

val paymentModule = module {
    factory { PaymentViewModel(get()) }
}
