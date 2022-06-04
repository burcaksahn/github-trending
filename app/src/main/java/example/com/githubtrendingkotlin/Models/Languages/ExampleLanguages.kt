package example.com.githubtrendingkotlin.Models.Languages

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ExampleLanguages {
    @SerializedName("urlParam")
    @Expose
    private var urlParam: String? = null

    @SerializedName("name")
    @Expose
    var name: String? = null

    fun getData() : MutableList<String>{
        val data : MutableList<String> = mutableListOf()
        urlParam?.let { data.add(it) }
        name?.let { data.add(it) }
        return data
    }

}