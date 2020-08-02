package com.egorsigolaev.alyaintstagram.app.view_holders

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Typeface
import android.os.Handler
import android.text.SpannableString
import android.text.TextUtils
import android.text.format.DateUtils
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.egorsigolaev.alyaintstagram.R
import com.egorsigolaev.alyaintstagram.app.App.Companion.TAG
import com.egorsigolaev.alyaintstagram.app.adapters.PostImagesAdapter
import com.egorsigolaev.alyaintstagram.app.enums.Posts
import com.egorsigolaev.alyaintstagram.app.models.Post
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_advert_video.view.*
import kotlinx.android.synthetic.main.item_post_image.view.imageViewProfile
import kotlinx.android.synthetic.main.item_post_image.view.recyclerViewPost
import kotlinx.android.synthetic.main.item_post_image.view.textViewAuthorComment
import kotlinx.android.synthetic.main.item_post_image.view.textViewPostTime
import kotlinx.android.synthetic.main.item_post_image.view.textViewProfileName
import kotlinx.android.synthetic.main.item_post_image.view.textViewShowComments
import java.util.*

class AdvertVideoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val imageViewProfile = itemView.imageViewProfile
    private val textViewProfileName = itemView.textViewProfileName
    private val recyclerViewPost = itemView.recyclerViewPost
    private val textViewPostViews = itemView.textViewPostViews
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
        textViewPostViews.text = post.viewsText
        textViewAuthorComment.text = post.allAuthorComment
        textViewPostTime.text = post.timeText
        textViewShowComments.text = post.commentsText
        textViewProfileName.text = post.profileName

        recyclerViewPost.isNestedScrollingEnabled = false
        recyclerViewPost.setHasFixedSize(true)
        recyclerViewPost.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerViewPost.adapter = PostImagesAdapter(
            urls = (post.postType as Posts.PostVideo).videosUrls,
            postType = post.postType!!
        )
        recyclerViewPost.onFlingListener = null
        PagerSnapHelper().attachToRecyclerView(recyclerViewPost)

    }

}