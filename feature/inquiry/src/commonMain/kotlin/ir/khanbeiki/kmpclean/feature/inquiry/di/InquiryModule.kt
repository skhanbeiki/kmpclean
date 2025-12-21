package ir.khanbeiki.kmpclean.feature.inquiry.di

import ir.khanbeiki.kmpclean.feature.inquiry.InquiryViewModel
import org.koin.dsl.module

val inquiryModule = module {
    factory { InquiryViewModel(get()) }
}
