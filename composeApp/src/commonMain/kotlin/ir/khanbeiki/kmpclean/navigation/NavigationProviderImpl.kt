package ir.khanbeiki.kmpclean.navigation

import cafe.adriel.voyager.core.screen.Screen
import ir.khanbeiki.kmpclean.feature.home.HomeScreen
import ir.khanbeiki.kmpclean.feature.inquiry.InquiryScreen
import ir.khanbeiki.kmpclean.feature.payment.PaymentScreen
import ir.khanbeiki.kmpclean.feature.registration.RegistrationScreen
import ir.khanbeiki.kmpclean.library.navigation.NavigationProvider

class NavigationProviderImpl : NavigationProvider {
    override fun provideRegistrationScreen(): Screen = RegistrationScreen()
    override fun providePaymentScreen(): Screen = PaymentScreen()
    override fun provideInquiryScreen(): Screen = InquiryScreen()
    override fun provideHomeScreen(): Screen = HomeScreen()
}
