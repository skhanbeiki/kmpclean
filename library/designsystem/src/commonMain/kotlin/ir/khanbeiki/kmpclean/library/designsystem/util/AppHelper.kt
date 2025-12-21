package ir.khanbeiki.kmpclean.library.designsystem.util

import ir.khanbeiki.kmpclean.library.designsystem.generated.resources.Res
import org.jetbrains.compose.resources.ExperimentalResourceApi

@OptIn(ExperimentalResourceApi::class)
suspend fun loadJsonFile(name: String): String {
    val bytes = Res.readBytes("files/$name.json")
    return bytes.decodeToString()
}
