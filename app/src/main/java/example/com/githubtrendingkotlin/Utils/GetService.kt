package example.com.githubtrendingkotlin.Utils

import android.telecom.Call
import example.com.githubtrendingkotlin.Models.Developers.ExampleDevelopers
import example.com.githubtrendingkotlin.Models.Languages.ExampleLanguages
import example.com.githubtrendingkotlin.Models.Repositories.Example
import example.com.githubtrendingkotlin.Models.SpokenLanguages.ExampleSpoken
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface GetService {
    @GET("repositories")
    fun getRepositories(@Header("x-rapidapi-key") key:String?,
                        @Header("x-rapidapi-host") host: String?,
                        @Query("language") language: String?,
                        @Query ("since") since:String?,
                        @Query("spoken_language_code") langCode : String?): retrofit2.Call<List<Example?>>?
    @GET("developers")
    fun getDevelopers(@Header("x-rapidapi-key") key:String?,
                        @Header("x-rapidapi-host") host: String?,
                        @Query("language") language: String?,
                        @Query ("since") since:String?,
                        @Query("spoken_language_code") langCode : String?): retrofit2.Call<List<ExampleDevelopers?>>?
    @GET("spoken_languages")
    fun getSpokenLanguages(@Header("x-rapidapi-key") key:String?,
                        @Header("x-rapidapi-host") host: String?): retrofit2.Call<List<ExampleSpoken?>>?

    @GET("languages")
    fun getLanguages(@Header("x-rapidapi-key") key:String?,
                        @Header("x-rapidapi-host") host: String?,
                        ): retrofit2.Call<List<ExampleLanguages?>>?
}