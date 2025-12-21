package ir.khanbeiki.kmpclean.feature.payment

import cafe.adriel.voyager.core.model.screenModelScope
import ir.khanbeiki.kmpclean.core.domain.usecase.PayUseCase
import ir.khanbeiki.kmpclean.core.base.BaseViewModel
import kotlinx.coroutines.launch

class PaymentViewModel(
    private val payUseCase: PayUseCase
) : BaseViewModel<PaymentState, PaymentIntent, PaymentEffect>(PaymentState()) {

    override fun process(intent: PaymentIntent) {
        when (intent) {
            is PaymentIntent.EnterAmount -> setState { copy(amount = intent.amount) }
            is PaymentIntent.EnterDescription -> setState { copy(description = intent.description) }
            is PaymentIntent.Pay -> pay()
        }
    }

    private fun pay() {
        val amountStr = state.value.amount
        val amount = amountStr.toLongOrNull()
        if (amount == null || amount <= 0) {
            setEffect { PaymentEffect.ShowToast("Invalid amount") }
            return
        }

        screenModelScope.launch {
            setState { copy(loading = true, error = null) }
            try {
                val payment = payUseCase(amount, state.value.description)
                setState { copy(loading = false, payment = payment) }
                setEffect { PaymentEffect.ShowToast("Payment Successful") }
            } catch (e: Exception) {
                setState { copy(loading = false, error = e.message) }
                setEffect { PaymentEffect.ShowToast("Error: ${e.message}") }
            }
        }
    }
}
