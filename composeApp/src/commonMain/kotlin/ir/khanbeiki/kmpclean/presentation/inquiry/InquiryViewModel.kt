package ir.khanbeiki.kmpclean.presentation.inquiry

import cafe.adriel.voyager.core.model.screenModelScope
import ir.khanbeiki.kmpclean.core.domain.usecase.InquireUseCase
import ir.khanbeiki.kmpclean.presentation.base.BaseViewModel
import kotlinx.coroutines.launch

class InquiryViewModel(
    private val inquireUseCase: InquireUseCase
) : BaseViewModel<InquiryState, InquiryIntent, InquiryEffect>(InquiryState()) {

    override fun process(intent: InquiryIntent) {
        when (intent) {
            is InquiryIntent.EnterReferenceId -> setState { copy(referenceId = intent.referenceId) }
            is InquiryIntent.Inquire -> inquire()
        }
    }

    private fun inquire() {
        val refId = state.value.referenceId
        if (refId.isBlank()) {
            setEffect { InquiryEffect.ShowToast("Reference ID cannot be empty") }
            return
        }

        screenModelScope.launch {
            setState { copy(loading = true, error = null) }
            try {
                val result = inquireUseCase(refId)
                setState { copy(loading = false, inquiry = result) }
                setEffect { InquiryEffect.ShowToast("Inquiry Successful") }
            } catch (e: Exception) {
                setState { copy(loading = false, error = e.message) }
                setEffect { InquiryEffect.ShowToast("Error: ${e.message}") }
            }
        }
    }
}
