package example.com.githubtrendingkotlin.ui.Projects

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


class FactoryProject(private val mApplication: Application, private val repo : RepoRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ProjectsViewModel(repo) as T
    }
}