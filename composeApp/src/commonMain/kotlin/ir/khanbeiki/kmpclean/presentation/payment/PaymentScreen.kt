package ir.khanbeiki.kmpclean.presentation.payment

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel

class PaymentScreen : Screen {
    @Composable
    override fun Content() {
        val viewModel = getScreenModel<PaymentViewModel>()
        val state by viewModel.state.collectAsState()

        LaunchedEffect(viewModel) {
            viewModel.effect.collect { effect ->
                when (effect) {
                    is PaymentEffect.ShowToast -> {
                        println("TOAST: ${effect.message}")
                    }
                }
            }
        }

        Column(
            modifier = Modifier.fillMaxSize().padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Payment")
            Spacer(modifier = Modifier.height(16.dp))

            TextField(
                value = state.amount,
                onValueChange = { viewModel.process(PaymentIntent.EnterAmount(it)) },
                label = { Text("Amount") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            Spacer(modifier = Modifier.height(8.dp))
            TextField(
                value = state.description,
                onValueChange = { viewModel.process(PaymentIntent.EnterDescription(it)) },
                label = { Text("Description") }
            )
            Spacer(modifier = Modifier.height(16.dp))

            if (state.loading) {
                CircularProgressIndicator()
            } else {
                Button(onClick = { viewModel.process(PaymentIntent.Pay) }) {
                    Text("Pay")
                }
            }

            state.error?.let {
                Spacer(modifier = Modifier.height(8.dp))
                Text("Error: $it")
            }
            
            state.payment?.let {
                Spacer(modifier = Modifier.height(8.dp))
                Text("Payment ID: ${it.id}, Status: ${it.status}")
            }
        }
    }
}
