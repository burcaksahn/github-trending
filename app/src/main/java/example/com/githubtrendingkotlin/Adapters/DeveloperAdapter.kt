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
import example.com.githubtrendingkotlin.Models.Developers.ExampleDevelopers
import example.com.githubtrendingkotlin.R

class DeveloperAdapter : ListAdapter<ExampleDevelopers, DeveloperAdapter.DeveloperHolder>(
    diffCallback
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DeveloperHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.developer_row, parent,
            false)
        return DeveloperHolder(itemView)
    }

    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: DeveloperHolder, position: Int) {
        with(getItem(position)) {
            holder.name.text = this.name
            holder.userName.text = this.username
            if(this.sponsorUrl?.equals("null") == false){
                holder.sponsorURL.text = this.sponsorUrl.toString()
                holder.sponsorURL.setTextColor(R.color.purple_500)

            }
            else{
                holder.sponsorURL.text = this.sponsorUrl.toString()
            }
            holder?.updateWithUrl(this.avatar.toString(),holder.avatar)

        }
    }


    fun getDeveloperAt(position: Int) = getItem(position)


    inner class DeveloperHolder(iv: View) : RecyclerView.ViewHolder(iv) {

        val name: TextView = itemView.findViewById(R.id.nameSurnameTw)
        val userName: TextView = itemView.findViewById(R.id.userNameTw)
        val sponsorURL : TextView = itemView.findViewById(R.id.sponsorURL)
        val avatar : ImageView = itemView.findViewById(R.id.avatar)

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

private val diffCallback = object : DiffUtil.ItemCallback<ExampleDevelopers>() {
    override fun areItemsTheSame(oldItem: ExampleDevelopers, newItem: ExampleDevelopers): Boolean {
        TODO("Not yet implemented")
    }

    override fun areContentsTheSame(
        oldItem: ExampleDevelopers,
        newItem: ExampleDevelopers
    ): Boolean {
        TODO("Not yet implemented")
    }
}