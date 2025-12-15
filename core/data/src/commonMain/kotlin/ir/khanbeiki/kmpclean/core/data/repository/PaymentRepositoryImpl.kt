package ir.khanbeiki.kmpclean.core.data.repository

import ir.khanbeiki.kmpclean.core.domain.model.Payment
import ir.khanbeiki.kmpclean.core.domain.repository.PaymentRepository
import io.ktor.client.HttpClient
import kotlinx.coroutines.delay

class PaymentRepositoryImpl(
    private val httpClient: HttpClient
) : PaymentRepository {
    override suspend fun pay(amount: Long, description: String): Payment {
        // Mock network call
        delay(1500)
        return Payment(
            id = "pay_456",
            amount = amount,
            status = "SUCCESS"
        )
    }
}
