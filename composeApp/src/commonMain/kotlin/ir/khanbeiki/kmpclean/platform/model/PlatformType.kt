package ir.khanbeiki.kmpclean.platform.model

import kotlinx.serialization.Serializable

@Serializable
enum class PlatformType {
    Android, iOS, Web, Desktop
}
