package example.com.githubtrendingkotlin.Models.SpokenLanguages

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ExampleSpoken {
    @SerializedName("urlParam")
    @Expose
    private var urlParam: String? = null

    @SerializedName("name")
    @Expose
    var name: String? = null

    fun getData(): String? {
        return name
    }

}

