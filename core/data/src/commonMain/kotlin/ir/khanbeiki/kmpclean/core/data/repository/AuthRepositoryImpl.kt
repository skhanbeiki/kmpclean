package ir.khanbeiki.kmpclean.core.data.repository

import ir.khanbeiki.kmpclean.core.data.datasource.local.preferences.PreferenceDataStoreHelper
import ir.khanbeiki.kmpclean.core.data.datasource.local.preferences.PreferencesKeys
import ir.khanbeiki.kmpclean.core.data.dto.auth.RegisterRequestDto
import ir.khanbeiki.kmpclean.core.data.dto.auth.RegisterResponseDto
import ir.khanbeiki.kmpclean.core.data.mapper.auth.toDomain
import ir.khanbeiki.kmpclean.core.domain.model.User
import ir.khanbeiki.kmpclean.core.domain.repository.AuthRepository
import io.ktor.client.HttpClient
import kotlinx.coroutines.delay

class AuthRepositoryImpl(
    private val httpClient: HttpClient,
    private val preferences: PreferenceDataStoreHelper
) : AuthRepository {
    override suspend fun register(username: String, password: String): User {
        // Create DTO
        val requestDto = RegisterRequestDto(username, password)
        
        // Mock network call using DTO (in real app we would send requestDto)
        delay(1000)
        
        // Mock response DTO
        val token = "mock_token_${username.hashCode()}"
        val responseDto = RegisterResponseDto(
            userId = "user_123",
            userName = requestDto.username,
            token = token
        )
        
        // Use preferences to simulate checking or saving something
        preferences.saveString(PreferencesKeys.TOKEN, responseDto.token)
        
        // Map to Domain
        return responseDto.toDomain()
    }
}
