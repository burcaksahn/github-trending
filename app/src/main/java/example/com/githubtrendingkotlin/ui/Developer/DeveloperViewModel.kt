package example.com.githubtrendingkotlin.ui.Developer

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import example.com.githubtrendingkotlin.Models.Developers.ExampleDevelopers

class DeveloperViewModel(private val mRepo : DevelopersRepo) : ViewModel() {
    private var quote : LiveData<List<ExampleDevelopers>>? = null

    fun getDeveloperData(language:String?): LiveData<List<ExampleDevelopers>>{
        quote = mRepo.getDevelopers(language)
        return quote as LiveData<List<ExampleDevelopers>>
    }
}