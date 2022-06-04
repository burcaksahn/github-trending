package example.com.githubtrendingkotlin.ui.Settings

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import example.com.githubtrendingkotlin.Models.Languages.ExampleLanguages
import example.com.githubtrendingkotlin.Models.SpokenLanguages.ExampleSpoken

class SettingsViewModel(private val spokenRepo: SpokenLanguagesRepository, private val languageRepo : LanguageRepository) : ViewModel() {
    private var spokenLanguage :  LiveData<List<ExampleSpoken>>?  = null
    private var language :  LiveData<List<ExampleLanguages>>?  = null

    fun getLanguagesData(): LiveData<List<ExampleLanguages>>{
        language = languageRepo.getLanguageData()
        return language as LiveData<List<ExampleLanguages>>
    }
    fun getSpokenLanguagesData(): LiveData<List<ExampleSpoken>>{
        spokenLanguage = spokenRepo.getSpokenData()
        return spokenLanguage as LiveData<List<ExampleSpoken>>
    }
}