package ir.khanbeiki.kmpclean

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform