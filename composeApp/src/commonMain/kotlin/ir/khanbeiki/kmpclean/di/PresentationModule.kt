package ir.khanbeiki.kmpclean.di

import ir.khanbeiki.kmpclean.presentation.inquiry.InquiryViewModel
import ir.khanbeiki.kmpclean.presentation.payment.PaymentViewModel
import ir.khanbeiki.kmpclean.presentation.registration.RegistrationViewModel
import org.koin.dsl.module

val presentationModule = module {
    factory { RegistrationViewModel(get()) }
    factory { PaymentViewModel(get()) }
    factory { InquiryViewModel(get()) }
}
