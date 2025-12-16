package ir.khanbeiki.kmpclean.di

import ir.khanbeiki.kmpclean.platform.ConfigProject
import ir.khanbeiki.kmpclean.presentation.inquiry.InquiryViewModel
import ir.khanbeiki.kmpclean.presentation.payment.PaymentViewModel
import ir.khanbeiki.kmpclean.presentation.registration.RegistrationViewModel
import ir.khanbeiki.kmpclean.AppViewModel
import org.koin.dsl.module

val presentationModule = module {
    single { ConfigProject() }
    factory { AppViewModel(get()) }
    factory { RegistrationViewModel(get()) }
    factory { PaymentViewModel(get()) }
    factory { InquiryViewModel(get()) }
}
