package ir.khanbeiki.kmpclean.library.navigation

import cafe.adriel.voyager.core.screen.Screen

interface NavigationProvider {
    fun provideRegistrationScreen(): Screen
    fun providePaymentScreen(): Screen
    fun provideInquiryScreen(): Screen
    fun provideHomeScreen(): Screen
}
