package ir.khanbeiki.kmpclean.di

import ir.khanbeiki.kmpclean.core.data.di.dataModule
import ir.khanbeiki.kmpclean.core.domain.di.domainModule
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun initKoin(appDeclaration: KoinAppDeclaration = {}) = startKoin {
    appDeclaration()
    modules(
        dataModule,
        domainModule,
        presentationModule
    )
}
