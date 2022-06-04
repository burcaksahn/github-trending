package example.com.githubtrendingkotlin.ui.Settings

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class FactorySettings(private val mApplication: Application, private val spokenRepo : SpokenLanguagesRepository, private val languageRepo : LanguageRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SettingsViewModel(spokenRepo ,languageRepo ) as T
    }
}