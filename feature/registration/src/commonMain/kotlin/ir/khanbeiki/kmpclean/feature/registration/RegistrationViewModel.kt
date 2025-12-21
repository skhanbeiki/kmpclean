package ir.khanbeiki.kmpclean.feature.registration

import cafe.adriel.voyager.core.model.screenModelScope
import ir.khanbeiki.kmpclean.core.domain.usecase.RegisterUseCase
import ir.khanbeiki.kmpclean.core.base.BaseViewModel
import kotlinx.coroutines.launch

class RegistrationViewModel(
    private val registerUseCase: RegisterUseCase
) : BaseViewModel<RegistrationState, RegistrationIntent, RegistrationEffect>(RegistrationState()) {

    override fun process(intent: RegistrationIntent) {
        when (intent) {
            is RegistrationIntent.EnterUsername -> {
                setState { copy(username = intent.username) }
            }
            is RegistrationIntent.Submit -> submit()
        }
    }

    private fun submit() {
        val username = state.value.username
        if (username.isBlank()) {
            setEffect { RegistrationEffect.ShowToast("Username cannot be empty") }
            return
        }

        screenModelScope.launch {
            setState { copy(loading = true, error = null) }
            try {
                val user = registerUseCase(username, "default_password")
                setState { copy(loading = false, user = user) }
                setEffect { RegistrationEffect.ShowToast("Registration Successful") }
                setEffect { RegistrationEffect.NavigateToHome }
            } catch (e: Exception) {
                setState { copy(loading = false, error = e.message) }
                setEffect { RegistrationEffect.ShowToast("Error: ${e.message}") }
            }
        }
    }
}
