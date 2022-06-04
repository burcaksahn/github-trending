package example.com.githubtrendingkotlin.Models.Developers

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Repo {
    @SerializedName("name")
    @Expose
    private var name: String? = null

    @SerializedName("description")
    @Expose
    private var description: String? = null

    @SerializedName("url")
    @Expose
    private var url: String? = null

    fun getData() : List<String>{
        val data : MutableList<String> = mutableListOf()
        name?.let { data.add(it) }
        description?.let { data.add(it) }
        url?.let { data.add(it) }
        return data
    }
}