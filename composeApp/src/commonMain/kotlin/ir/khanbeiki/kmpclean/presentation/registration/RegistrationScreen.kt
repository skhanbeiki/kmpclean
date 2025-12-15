package ir.khanbeiki.kmpclean.presentation.registration

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel

class RegistrationScreen : Screen {
    @Composable
    override fun Content() {
        val viewModel = getScreenModel<RegistrationViewModel>()
        val state by viewModel.state.collectAsState()

        LaunchedEffect(viewModel) {
            viewModel.effect.collect { effect ->
                when (effect) {
                    is RegistrationEffect.ShowToast -> {
                        println("TOAST: ${effect.message}") // In real app, use Snackbar or Toast
                    }
                    is RegistrationEffect.NavigateToHome -> {
                        println("NAVIGATE: Home")
                    }
                }
            }
        }

        Column(
            modifier = Modifier.fillMaxSize().padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Registration")
            Spacer(modifier = Modifier.height(16.dp))

            TextField(
                value = state.username,
                onValueChange = { viewModel.process(RegistrationIntent.EnterUsername(it)) },
                label = { Text("Username") }
            )
            Spacer(modifier = Modifier.height(16.dp))

            if (state.loading) {
                CircularProgressIndicator()
            } else {
                Button(onClick = {
                    viewModel.process(RegistrationIntent.Submit)
                }) {
                    Text("Register")
                }
            }

            state.error?.let {
                Spacer(modifier = Modifier.height(8.dp))
                Text("Error: $it")
            }
            
            state.user?.let {
                Spacer(modifier = Modifier.height(8.dp))
                Text("Registered: ${it.username}")
            }
        }
    }
}
