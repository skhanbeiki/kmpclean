package ir.khanbeiki.kmpclean.core.data.repository

import ir.khanbeiki.kmpclean.core.domain.model.Inquiry
import ir.khanbeiki.kmpclean.core.domain.repository.InquiryRepository
import io.ktor.client.HttpClient
import kotlinx.coroutines.delay

class InquiryRepositoryImpl(
    private val httpClient: HttpClient
) : InquiryRepository {
    override suspend fun inquire(referenceId: String): Inquiry {
        // Mock network call
        delay(800)
        return Inquiry(
            id = "inq_789",
            result = "Confirmed for Reference: $referenceId"
        )
    }
}
