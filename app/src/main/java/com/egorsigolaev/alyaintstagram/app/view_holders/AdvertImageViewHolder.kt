package com.egorsigolaev.alyaintstagram.app.view_holders

import android.annotation.SuppressLint
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.egorsigolaev.alyaintstagram.R
import com.egorsigolaev.alyaintstagram.app.adapters.PostImagesAdapter
import com.egorsigolaev.alyaintstagram.app.enums.Posts
import com.egorsigolaev.alyaintstagram.app.models.Post
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_post_image.view.*

class AdvertImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val imageViewProfile = itemView.imageViewProfile
    private val textViewProfileName = itemView.textViewProfileName
    private val recyclerViewPost = itemView.recyclerViewPost
    private val textViewPostLikes = itemView.textViewPostLikes
    private val textViewPostTime = itemView.textViewPostTime
    private val textViewAuthorComment = itemView.textViewAuthorComment
    private val textViewShowComments = itemView.textViewShowComments


    @SuppressLint("SetTextI18n")
    fun bind(post: Post) {

        val context = itemView.context

        Picasso.get()
            .load(post.profileImageUrl)
            .placeholder(R.drawable.ic_avatar)
            .into(imageViewProfile)

        imageViewProfile.borderWidth = post.storyBorderWidth
        imageViewProfile.borderColor = post.storyBorderColor
        textViewPostLikes.text = post.likesText
        textViewAuthorComment.text = post.allAuthorComment
        textViewPostTime.text = post.timeText
        textViewShowComments.text = post.commentsText
        textViewProfileName.text = post.profileName

        recyclerViewPost.isNestedScrollingEnabled = false
        recyclerViewPost.setHasFixedSize(true)
        recyclerViewPost.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerViewPost.adapter = PostImagesAdapter(
            urls = (post.postType as Posts.PostImage).imagesUrls,
            postType = post.postType!!
        )
        recyclerViewPost.onFlingListener = null
        PagerSnapHelper().attachToRecyclerView(recyclerViewPost)
    }

}