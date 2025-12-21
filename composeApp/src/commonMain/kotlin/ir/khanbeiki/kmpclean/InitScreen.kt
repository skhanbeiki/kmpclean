package ir.khanbeiki.kmpclean

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.koinScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import ir.khanbeiki.kmpclean.library.navigation.NavigationProvider
import org.koin.compose.koinInject

class InitScreen : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val viewModel = koinScreenModel<AppViewModel>()
        val language by viewModel.language.collectAsState()
        val navigationProvider = koinInject<NavigationProvider>()

        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            if (language == null) {
                CircularProgressIndicator()
            } else {
                navigator.replace(navigationProvider.provideHomeScreen())
            }
        }
    }
}
