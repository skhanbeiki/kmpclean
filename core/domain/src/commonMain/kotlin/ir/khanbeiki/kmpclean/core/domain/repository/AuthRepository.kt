package ir.khanbeiki.kmpclean.core.domain.repository

import ir.khanbeiki.kmpclean.core.domain.model.User

interface AuthRepository {
    suspend fun register(username: String, password: String): User
}
