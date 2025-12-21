package ir.khanbeiki.kmpclean.feature.inquiry

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
import cafe.adriel.voyager.koin.koinScreenModel

class InquiryScreen : Screen {
    @Composable
    override fun Content() {
        val viewModel = koinScreenModel<InquiryViewModel>()
        val state by viewModel.state.collectAsState()

        LaunchedEffect(viewModel) {
            viewModel.effect.collect { effect ->
                when (effect) {
                    is InquiryEffect.ShowToast -> {
                        println("TOAST: ${effect.message}")
                    }
                }
            }
        }

        Column(
            modifier = Modifier.fillMaxSize().padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Inquiry")
            Spacer(modifier = Modifier.height(16.dp))

            TextField(
                value = state.referenceId,
                onValueChange = { viewModel.process(InquiryIntent.EnterReferenceId(it)) },
                label = { Text("Reference ID") }
            )
            Spacer(modifier = Modifier.height(16.dp))

            if (state.loading) {
                CircularProgressIndicator()
            } else {
                Button(onClick = { viewModel.process(InquiryIntent.Inquire) }) {
                    Text("Inquire")
                }
            }

            state.error?.let {
                Spacer(modifier = Modifier.height(8.dp))
                Text("Error: $it")
            }
            
            state.inquiry?.let {
                Spacer(modifier = Modifier.height(8.dp))
                Text("Result: ${it.result}")
            }
        }
    }
}
