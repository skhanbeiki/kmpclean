package ir.khanbeiki.kmpclean.core.data.mapper.auth

import ir.khanbeiki.kmpclean.core.data.dto.auth.RegisterResponseDto
import ir.khanbeiki.kmpclean.core.domain.model.User

fun RegisterResponseDto.toDomain(): User {
    return User(
        id = this.userId,
        username = this.userName,
        token = this.token
    )
}
