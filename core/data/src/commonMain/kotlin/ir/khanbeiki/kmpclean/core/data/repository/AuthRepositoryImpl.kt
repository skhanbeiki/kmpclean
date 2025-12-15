package ir.khanbeiki.kmpclean.core.data.repository

import ir.khanbeiki.kmpclean.core.domain.model.User
import ir.khanbeiki.kmpclean.core.domain.repository.AuthRepository
import io.ktor.client.HttpClient
import kotlinx.coroutines.delay

class AuthRepositoryImpl(
    private val httpClient: HttpClient
) : AuthRepository {
    override suspend fun register(username: String, password: String): User {
        // Mock network call
        delay(1000)
        return User(
            id = "user_123",
            username = username,
            token = "mock_token_${username.hashCode()}"
        )
    }
}
