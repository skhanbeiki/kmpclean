package ir.khanbeiki.kmpclean

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.koin.getScreenModel
import ir.khanbeiki.kmpclean.presentation.home.HomeScreen
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    // We can't use koinViewModel or getScreenModel here directly because App is not a Screen.
    // However, we can use Koin's koinInject if we want, or just let Voyager handle it in the Screen.
    // But we need to initialize the config.
    // For simplicity in this structure, we can wrap the Navigator in a component that fetches the VM.
    
    // Actually, App is the entry point. We can use Koin here.
    // But since we don't have a "screen" context for Voyager's ScreenModel yet, we might need a workaround or just use a standard ViewModel approach or a LaunchedEffect.
    // Let's use a wrapper Composable that gets the ViewModel.
    
    AppContent()
}

@Composable
fun AppContent() {
    // Note: getScreenModel is for Voyager Screens. For the root App, we might need standard Koin.
    // Or we can just use a simple LaunchedEffect to init config if we don't strictly need a ViewModel here.
    // But let's try to follow the pattern.
    
    // Since we are inside Koin context (initialized in platform specific code), we can retrieve instances.
    // But `koinViewModel` is from `koin-compose-viewmodel`.
    
    // Let's use a standard Koin injection for the AppViewModel or similar.
    // Since AppViewModel extends ScreenModel, it's designed for Voyager.
    // But we are at the root.
    
    // AyanHooks uses `koinViewModel<AppViewModel>()`.
    
    MaterialTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
             // We need to trigger the init block of AppViewModel
             // We can create a "Splash" or "Loader" screen that does this, or do it here.
             
             // Let's assume we can get it.
             // val appViewModel = koinViewModel<AppViewModel>() // This requires `koin-compose-viewmodel` dependency which we have.
             
             // However, `AppViewModel` in our code extends `ScreenModel`.
             // `koinViewModel` expects `androidx.lifecycle.ViewModel`.
             // If we want to use `ScreenModel` with Voyager, we should probably start with a Screen that does the initialization.
             
             Navigator(InitScreen())
        }
    }
}
