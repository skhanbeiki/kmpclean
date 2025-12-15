package ir.khanbeiki.kmpclean

import androidx.compose.ui.window.ComposeUIViewController
import ir.khanbeiki.kmpclean.di.initKoin

fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) { App() }
