package example.com.githubtrendingkotlin.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import example.com.githubtrendingkotlin.Models.Languages.ExampleLanguages
import example.com.githubtrendingkotlin.R

class LanguageAdapter : ListAdapter<ExampleLanguages, LanguageAdapter.LanguageHolder>(
        diffCallback
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LanguageHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
                R.layout.languages_row, parent,
                false)
        return LanguageHolder(itemView)
    }

    override fun onBindViewHolder(holder: LanguageHolder, position: Int) {
        with(getItem(position)) {
            holder.name.text = this.name
        }
    }


    fun getLanguageAt(position: Int) = getItem(position)


    inner class LanguageHolder(iv: View) : RecyclerView.ViewHolder(iv) {

        val name: TextView = itemView.findViewById(R.id.languageTw)

    }
}

private val diffCallback = object : DiffUtil.ItemCallback<ExampleLanguages>() {
    override fun areItemsTheSame(oldItem: ExampleLanguages, newItem: ExampleLanguages): Boolean {
        TODO("Not yet implemented")
    }

    override fun areContentsTheSame(
            oldItem: ExampleLanguages,
            newItem: ExampleLanguages
    ): Boolean {
        TODO("Not yet implemented")
    }
}