package ir.khanbeiki.kmpclean.core.domain.usecase

import ir.khanbeiki.kmpclean.core.domain.model.User
import ir.khanbeiki.kmpclean.core.domain.repository.AuthRepository

class RegisterUseCase(private val repository: AuthRepository) {
    suspend operator fun invoke(username: String, password: String): User {
        // Validation logic can be added here
        if (username.isBlank() || password.isBlank()) {
            throw IllegalArgumentException("Username and password cannot be empty")
        }
        return repository.register(username, password)
    }
}
