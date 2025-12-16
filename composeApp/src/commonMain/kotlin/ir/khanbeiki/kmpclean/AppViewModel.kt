package ir.khanbeiki.kmpclean

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import ir.khanbeiki.kmpclean.platform.ConfigProject
import ir.khanbeiki.kmpclean.presentation.ui.util.AppLanguage
import ir.khanbeiki.kmpclean.presentation.ui.util.LanguageManager
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AppViewModel(
    private val configProject: ConfigProject
) : ScreenModel {

    private val _language = MutableStateFlow<AppLanguage?>(null)
    val language: StateFlow<AppLanguage?> = _language

    init {
        screenModelScope.launch {
            configProject.getConfigProject()
            // Default language for now
            _language.value = AppLanguage.FA
            LanguageManager.currentLanguage = AppLanguage.FA
        }
    }
}
