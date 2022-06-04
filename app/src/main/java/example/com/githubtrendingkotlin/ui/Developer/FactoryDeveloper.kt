package example.com.githubtrendingkotlin.ui.Developer

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class FactoryDeveloper(private val mApplication: Application, private val repo : DevelopersRepo) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return DeveloperViewModel(repo) as T
    }
}