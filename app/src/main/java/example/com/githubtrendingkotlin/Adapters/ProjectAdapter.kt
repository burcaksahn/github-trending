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
import example.com.githubtrendingkotlin.R

class ProjectAdapter : ListAdapter<Example, ProjectAdapter.ProjectHolder>(
    diffCallback
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProjectHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.projects_row, parent,
            false)
        return ProjectHolder(itemView)
    }

    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: ProjectHolder, position: Int) {
        with(getItem(position)) {
            holder.author.text = this.author
            holder.name.text = this.name
            holder.language.text = this.language
            holder.currentPeriod.text = this.currentPeriodStars.toString()
            holder.stars.text = this.stars.toString()
            holder.description.text = this.description
            holder.forks.text = this.forks.toString()
            //holder.language.setTextColor(this.languageColor)
            holder?.updateWithUrl(this.avatar.toString(),holder.avatar)

        }
    }


    fun getDeveloperAt(position: Int) = getItem(position)


    inner class ProjectHolder(iv: View) : RecyclerView.ViewHolder(iv) {

        val name: TextView = itemView.findViewById(R.id.projectUserNameTw)
        val author: TextView = itemView.findViewById(R.id.authorTw)
        val language : TextView = itemView.findViewById(R.id.languageTw)
        val description : TextView = itemView.findViewById(R.id.descriptionTw)
        val forks : TextView = itemView.findViewById(R.id.forksTw)
        val stars : TextView = itemView.findViewById(R.id.starsTw)
        val currentPeriod : TextView = itemView.findViewById(R.id.currentStarsTw)
        val avatar : ImageView = itemView.findViewById(R.id.avatarProject)

        /* init {
             itemView.setOnClickListener {
                 if(adapterPosition != RecyclerView.NO_POSITION)
                     onItemClickListener(getItem(adapterPosition))
             }
         }*/
        fun updateWithUrl(url: String, imageViewAvatar : ImageView) {
            Picasso.get().load(url).centerCrop().resize(200,200).into(imageViewAvatar)
        }
    }
}

private val diffCallback = object : DiffUtil.ItemCallback<Example>() {
    override fun areItemsTheSame(oldItem: Example, newItem: Example): Boolean {
        TODO("Not yet implemented")
    }

    override fun areContentsTheSame(
        oldItem: Example,
        newItem: Example
    ): Boolean {
        TODO("Not yet implemented")
    }
}