package example.com.githubtrendingkotlin.ui.Settings

import android.util.Log
import androidx.lifecycle.MutableLiveData
import example.com.githubtrendingkotlin.Models.SpokenLanguages.ExampleSpoken
import example.com.githubtrendingkotlin.Utils.Api
import example.com.githubtrendingkotlin.Utils.GetService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SpokenLanguagesRepository (private val key: String?, private val host : String?) {
    var endpoints : Api = Api()
    fun getSpokenData() : MutableLiveData<List<ExampleSpoken>> {

        val apiResponse = MutableLiveData<List<ExampleSpoken>>()
        val apiService = endpoints.getClient()!!.create(GetService::class.java)
        val call : Call<List<ExampleSpoken?>>? = apiService.getSpokenLanguages(key, host)
        call?.enqueue(object : Callback<List<ExampleSpoken?>> {
            override fun onFailure(call: Call<List<ExampleSpoken?>>, t: Throwable) {
            }

            override fun onResponse(
                call: Call<List<ExampleSpoken?>>,
                response: Response<List<ExampleSpoken?>>
            ) {
                if (response!!.isSuccessful) {
                     apiResponse.postValue(response.body()!! as List<ExampleSpoken>?)
                } else {
                    Log.d("TAG", "onResponse: Not Success")
                }
            }

        })
        return apiResponse
    }
}