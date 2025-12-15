package ir.khanbeiki.kmpclean.core.domain.model

data class Payment(
    val id: String,
    val amount: Long,
    val status: String
)
