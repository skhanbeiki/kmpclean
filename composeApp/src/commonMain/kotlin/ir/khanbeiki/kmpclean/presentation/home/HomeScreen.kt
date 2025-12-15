package ir.khanbeiki.kmpclean.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import ir.khanbeiki.kmpclean.presentation.inquiry.InquiryScreen
import ir.khanbeiki.kmpclean.presentation.payment.PaymentScreen
import ir.khanbeiki.kmpclean.presentation.registration.RegistrationScreen

class HomeScreen : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow

        Column(
            modifier = Modifier.fillMaxSize().padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = { navigator.push(RegistrationScreen()) }) {
                Text("Go to Registration")
            }
            Button(onClick = { navigator.push(PaymentScreen()) }) {
                Text("Go to Payment")
            }
            Button(onClick = { navigator.push(InquiryScreen()) }) {
                Text("Go to Inquiry")
            }
        }
    }
}
