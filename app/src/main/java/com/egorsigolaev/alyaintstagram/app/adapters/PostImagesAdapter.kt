package com.egorsigolaev.alyaintstagram.app.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.PagerAdapter
import com.egorsigolaev.alyaintstagram.R
import com.egorsigolaev.alyaintstagram.app.models.PostImage
import kotlinx.android.synthetic.main.item_post_image.view.*

//class PostImagesAdapter(var postImages: List<PostImage>, var context: Context): PagerAdapter() {
//
//    override fun isViewFromObject(view: View, obj: Any): Boolean {
//        return view == obj
//    }
//
//    override fun getCount(): Int {
//        return postImages.size
//    }
//
//    override fun instantiateItem(container: ViewGroup, position: Int): Any {
//        val imageView = ImageView(context)
//        imageView.adjustViewBounds = true
//        val imageResId = postImages[position].resId
//        imageResId?.let {
//            imageView.setImageResource(imageResId)
//        }
//        container.addView(imageView, 0)
//        return imageView
//
//    }
//
//    override fun destroyItem(container: ViewGroup, position: Int, obj: Any) {
//        container.removeView(obj as ImageView)
//    }
//
//
//}

class PostImagesAdapter(var images: List<PostImage>): RecyclerView.Adapter<PostImagesAdapter.PostImagesHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostImagesHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_post_image, parent, false)
        return PostImagesHolder(itemView = view)
    }

    override fun getItemCount(): Int {
        return images.size
    }

    override fun onBindViewHolder(holder: PostImagesHolder, position: Int) {
        holder.bind(images[position])
    }

    inner class PostImagesHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageViewPostImage = itemView.imageViewPostImage

        fun bind(postImage: PostImage){
            val resId = postImage.resId
            resId?.let {
                imageViewPostImage.setImageResource(it)
            }

        }
    }

}