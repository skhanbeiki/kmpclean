package ir.khanbeiki.kmpclean.core.domain.repository

import ir.khanbeiki.kmpclean.core.domain.model.Payment

interface PaymentRepository {
    suspend fun pay(amount: Long, description: String): Payment
}
