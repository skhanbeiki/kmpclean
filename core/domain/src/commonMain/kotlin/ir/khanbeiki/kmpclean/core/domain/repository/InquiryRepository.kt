package ir.khanbeiki.kmpclean.core.domain.repository

import ir.khanbeiki.kmpclean.core.domain.model.Inquiry

interface InquiryRepository {
    suspend fun inquire(referenceId: String): Inquiry
}
