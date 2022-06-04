package example.com.githubtrendingkotlin.Adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import example.com.githubtrendingkotlin.Models.Repositories.Example
import example.com.githubtrendingkotlin.Models.SpokenLanguages.ExampleSpoken
import example.com.githubtrendingkotlin.R

class SpokenLanguagesAdapter : ListAdapter<ExampleSpoken, SpokenLanguagesAdapter.SpokenLanguagesHolder>(
        diffCallback
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpokenLanguagesHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
                R.layout.spoken_language_row, parent,
                false)
        return SpokenLanguagesHolder(itemView)
    }

    override fun onBindViewHolder(holder: SpokenLanguagesHolder, position: Int) {
        with(getItem(position)) {
            holder.name.text = this.name
        }
    }


    fun getDeveloperAt(position: Int) = getItem(position)


    inner class SpokenLanguagesHolder(iv: View) : RecyclerView.ViewHolder(iv) {

        val name: TextView = itemView.findViewById(R.id.spokenLanguageTw)

    }
}

private val diffCallback = object : DiffUtil.ItemCallback<ExampleSpoken>() {
    override fun areItemsTheSame(oldItem: ExampleSpoken, newItem: ExampleSpoken): Boolean {
        TODO("Not yet implemented")
    }

    override fun areContentsTheSame(
            oldItem: ExampleSpoken,
            newItem: ExampleSpoken
    ): Boolean {
        TODO("Not yet implemented")
    }
}