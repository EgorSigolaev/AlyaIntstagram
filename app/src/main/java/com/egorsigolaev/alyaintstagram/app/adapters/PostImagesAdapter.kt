package com.egorsigolaev.alyaintstagram.app.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.egorsigolaev.alyaintstagram.R
import com.egorsigolaev.alyaintstagram.app.enums.Posts
import com.egorsigolaev.alyaintstagram.helpers.getScreenWidthInPx
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_image.view.*
import kotlinx.android.synthetic.main.item_video.view.*


class PostImagesAdapter(var urls: List<String>, var postType: Posts): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if(postType is Posts.PostImage || postType is Posts.AdvertImage){
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_image, parent, false)
            PostImagesHolder(itemView = view)
        }else{
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_video, parent, false)
            PostVideosHolder(itemView = view)
        }
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        this.recyclerView = recyclerView
    }

    override fun getItemCount(): Int {
        return urls.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(postType is Posts.PostImage || postType is Posts.AdvertImage){
            (holder as PostImagesHolder).bind(urls[position])
        }else{
            (holder as PostVideosHolder).bind(urls[position])
        }
    }

    inner class PostImagesHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageViewPostImage = itemView.imageViewPostImage

        fun bind(url: String){
            Picasso.get()
                .load(url)
                .resize(getScreenWidthInPx(itemView.context), getScreenWidthInPx(itemView.context))
                .centerCrop()
                .placeholder(R.color.grey)
                .into(imageViewPostImage)
        }
    }

    inner class PostVideosHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val textViewVideo = itemView.textViewVideo

        fun bind(url: String){
            when(postType){
                is Posts.PostVideo -> textViewVideo.text = "Видео - пост"
                is Posts.AdvertVideo -> textViewVideo.text = "Видео - реклама"
            }
        }
    }

}