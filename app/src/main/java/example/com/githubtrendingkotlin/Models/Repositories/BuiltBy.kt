package example.com.githubtrendingkotlin.Models.Repositories

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class BuiltBy {

    @SerializedName("username")
    @Expose
    private var username: String? = null

    @SerializedName("href")
    @Expose
    private var href: String? = null

    @SerializedName("avatar")
    @Expose
    private var avatar: String? = null

}