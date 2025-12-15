package ir.khanbeiki.kmpclean.presentation.payment

import ir.khanbeiki.kmpclean.core.domain.model.Payment

data class PaymentState(
    val amount: String = "",
    val description: String = "",
    val loading: Boolean = false,
    val payment: Payment? = null,
    val error: String? = null
)

sealed class PaymentIntent {
    data class EnterAmount(val amount: String) : PaymentIntent()
    data class EnterDescription(val description: String) : PaymentIntent()
    object Pay : PaymentIntent()
}

sealed class PaymentEffect {
    data class ShowToast(val message: String) : PaymentEffect()
}
