package ir.khanbeiki.kmpclean.presentation.inquiry

import ir.khanbeiki.kmpclean.core.domain.model.Inquiry

data class InquiryState(
    val referenceId: String = "",
    val loading: Boolean = false,
    val inquiry: Inquiry? = null,
    val error: String? = null
)

sealed class InquiryIntent {
    data class EnterReferenceId(val referenceId: String) : InquiryIntent()
    object Inquire : InquiryIntent()
}

sealed class InquiryEffect {
    data class ShowToast(val message: String) : InquiryEffect()
}
