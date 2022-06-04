package example.com.githubtrendingkotlin.ui.Settings

import android.util.Log
import androidx.lifecycle.MutableLiveData
import example.com.githubtrendingkotlin.Models.Languages.ExampleLanguages
import example.com.githubtrendingkotlin.Utils.Api
import example.com.githubtrendingkotlin.Utils.GetService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LanguageRepository(private val key: String?, private val host : String?) {
    var endpoints : Api = Api()
    fun getLanguageData() : MutableLiveData<List<ExampleLanguages>>? {
        val apiResponse = MutableLiveData<List<ExampleLanguages>>()
        val apiService = endpoints.getClient()!!.create(GetService::class.java)
        val call : Call<List<ExampleLanguages?>>? = apiService.getLanguages(key, host)
        call?.enqueue(object : Callback<List<ExampleLanguages?>> {
            override fun onFailure(call: Call<List<ExampleLanguages?>>, t: Throwable) {
            }

            override fun onResponse(
                call: Call<List<ExampleLanguages?>>,
                response: Response<List<ExampleLanguages?>>
            ) {
                if (response!!.isSuccessful) {
                     apiResponse.postValue(response.body()!! as List<ExampleLanguages>?)
                } else {
                    Log.d("TAG", "onResponse: Not Success")
                }
            }

        })
        return apiResponse
    }
}