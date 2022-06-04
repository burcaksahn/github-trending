package example.com.githubtrendingkotlin.Models.Developers

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ExampleDevelopers {
    @SerializedName("username")
    @Expose
    var username: String? = null

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("url")
    @Expose
    var url: String? = null

    @SerializedName("sponsorUrl")
    @Expose
    var sponsorUrl: Any? = null

    @SerializedName("avatar")
    @Expose
    var avatar: String? = null

    @SerializedName("repo")
    @Expose
    var repo: Repo? = null

    fun getData() : String{

        val data  = username+ "!!?" + name+ "!!?" + url+"!!?" + sponsorUrl+"!!?" + avatar+repo?.getData().toString()
        return data
    }
}