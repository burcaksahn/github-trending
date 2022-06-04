package example.com.githubtrendingkotlin.ui.Projects

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import example.com.githubtrendingkotlin.Models.Repositories.Example
import example.com.githubtrendingkotlin.Utils.Api
import example.com.githubtrendingkotlin.Utils.GetService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RepoRepository(private val key: String?, private val host : String?, private val language : String?, private val since : String, private val langCode : String?) {
    var endpoints : Api = Api()
    fun getRepositories() :  LiveData<List<Example>> {
        val apiResponse = MutableLiveData<List<Example>>()
        val apiService = endpoints.getClient()!!.create(GetService::class.java)
        val call : Call<List<Example?>>? = apiService.getRepositories(key, host, language, since, langCode)
        call?.enqueue(object : Callback<List<Example?>> {
            override fun onFailure(call: Call<List<Example?>>, t: Throwable) {
            }

            override fun onResponse(
                call: Call<List<Example?>>,
                response: Response<List<Example?>>
            ) {
                if (response!!.isSuccessful) {
                     apiResponse.postValue(response.body()!! as List<Example>?)
                } else {
                    Log.d("TAG", "onResponse: Not Success")
                }
            }

        })
        return apiResponse
    }
}

