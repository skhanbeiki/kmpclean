package ir.khanbeiki.kmpclean.library.designsystem.theme

import ir.khanbeiki.kmpclean.library.designsystem.generated.resources.Res
import ir.khanbeiki.kmpclean.library.designsystem.generated.resources.compose_multiplatform
import org.jetbrains.compose.resources.DrawableResource

object AppImages {
    var logo: DrawableResource = Res.drawable.compose_multiplatform
    var background: DrawableResource = Res.drawable.compose_multiplatform

    fun logo(name: String) {
        when (name) {
            "ic_water_logo", "ic_electricity_logo", "ic_gas_logo", "ic_phone_logo", "ic_mobile_logo" -> {
                logo = Res.drawable.compose_multiplatform
            }
            else -> {
                logo = Res.drawable.compose_multiplatform
            }
        }
        background = Res.drawable.compose_multiplatform
    }
}
