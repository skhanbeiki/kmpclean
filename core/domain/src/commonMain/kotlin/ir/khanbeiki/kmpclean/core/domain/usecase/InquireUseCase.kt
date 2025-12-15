package ir.khanbeiki.kmpclean.core.domain.usecase

import ir.khanbeiki.kmpclean.core.domain.model.Inquiry
import ir.khanbeiki.kmpclean.core.domain.repository.InquiryRepository

class InquireUseCase(private val repository: InquiryRepository) {
    suspend operator fun invoke(referenceId: String): Inquiry {
        if (referenceId.isBlank()) {
            throw IllegalArgumentException("Reference ID cannot be empty")
        }
        return repository.inquire(referenceId)
    }
}
