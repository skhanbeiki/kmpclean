package ir.khanbeiki.kmpclean.presentation.ui.theme

import kmpclean.composeapp.generated.resources.Res
import kmpclean.composeapp.generated.resources.compose_multiplatform
import org.jetbrains.compose.resources.DrawableResource

object AppImages {
    var logo: DrawableResource = Res.drawable.compose_multiplatform
    var background: DrawableResource = Res.drawable.compose_multiplatform

    fun logo(name: String) {
        // Map string names to actual resources
        // For now, we map everything to the default or specific ones if available
        when (name) {
            "ic_water_logo", "ic_electricity_logo", "ic_gas_logo", "ic_phone_logo", "ic_mobile_logo" -> {
                logo = Res.drawable.compose_multiplatform
            }
            else -> {
                logo = Res.drawable.compose_multiplatform
            }
        }
        
        // Also set background if needed, based on logic
        background = Res.drawable.compose_multiplatform
    }
}
