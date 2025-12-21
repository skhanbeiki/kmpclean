package ir.khanbeiki.kmpclean.feature.registration

import ir.khanbeiki.kmpclean.core.domain.model.User

data class RegistrationState(
    val username: String = "",
    val loading: Boolean = false,
    val user: User? = null,
    val error: String? = null
)

sealed class RegistrationIntent {
    data class EnterUsername(val username: String) : RegistrationIntent()
    object Submit : RegistrationIntent()
}

sealed class RegistrationEffect {
    data class ShowToast(val message: String) : RegistrationEffect()
    object NavigateToHome : RegistrationEffect()
}
