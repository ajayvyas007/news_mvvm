package com.ajay.tech.news

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ajay.tech.news.data.remote.response.Post
import com.bumptech.glide.Glide


/**
 * Created by Ajay Vyas on 24/05/20.
 * Own Project
 * ajv_007@hotmail.com
 */
class PostAdapter(var data: List<Post>): RecyclerView.Adapter<PostAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        data?.let {
            return data.size
        }

        return 0;
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val holderView = holder as ViewHolder

        holderView.imageView?.let {
            Glide.with(holderView.itemView.context).load(data[position].imageUrl).into(
                it
            )
        }

        holder.title?.text = data[position].event_name
        holder.view?.text = "View "+data[position].views.toString()
        holder.like?.text = "Like "+data[position].likes.toString()
        holder.share?.text = "Share "+data[position].shares.toString()
    }

    class ViewHolder(val item: View): RecyclerView.ViewHolder(item){

        var imageView: ImageView? = null
        var title: TextView? = null
        var view: Button? = null
        var like: Button?= null
        var share: Button? = null

        init {
            imageView = item.findViewById(R.id.imageView)
            title = item.findViewById(R.id.title)
            view = item.findViewById(R.id.views)
            like = item.findViewById(R.id.likes)
            share = item.findViewById(R.id.share)
        }
    }
}