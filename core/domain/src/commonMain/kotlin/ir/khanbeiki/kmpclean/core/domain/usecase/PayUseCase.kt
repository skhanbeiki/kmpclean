package ir.khanbeiki.kmpclean.core.domain.usecase

import ir.khanbeiki.kmpclean.core.domain.model.Payment
import ir.khanbeiki.kmpclean.core.domain.repository.PaymentRepository

class PayUseCase(private val repository: PaymentRepository) {
    suspend operator fun invoke(amount: Long, description: String): Payment {
        if (amount <= 0) {
            throw IllegalArgumentException("Amount must be greater than zero")
        }
        return repository.pay(amount, description)
    }
}
