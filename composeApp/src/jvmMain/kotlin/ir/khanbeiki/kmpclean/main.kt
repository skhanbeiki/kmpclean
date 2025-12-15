package ir.khanbeiki.kmpclean

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import ir.khanbeiki.kmpclean.di.initKoin

fun main() = application {
    initKoin()
    Window(
        onCloseRequest = ::exitApplication,
        title = "MyApplication",
    ) {
        App()
    }
}
