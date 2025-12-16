package ir.khanbeiki.kmpclean.core.data.dto.auth

import kotlinx.serialization.Serializable

@Serializable
data class RegisterRequestDto(
    val username: String,
    val password: String
)

@Serializable
data class RegisterResponseDto(
    val userId: String,
    val userName: String,
    val token: String
)
