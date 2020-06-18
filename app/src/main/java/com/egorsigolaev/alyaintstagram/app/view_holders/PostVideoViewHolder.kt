package com.egorsigolaev.alyaintstagram.app.view_holders

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Typeface
import android.text.SpannableString
import android.text.TextUtils
import android.text.format.DateUtils
import android.text.format.DateUtils.FORMAT_ABBREV_RELATIVE
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
import kotlinx.android.synthetic.main.item_post_image.view.imageViewProfile
import kotlinx.android.synthetic.main.item_post_image.view.recyclerViewPost
import kotlinx.android.synthetic.main.item_post_image.view.textViewAuthorComment
import kotlinx.android.synthetic.main.item_post_image.view.textViewPostTime
import kotlinx.android.synthetic.main.item_post_image.view.textViewProfileName
import kotlinx.android.synthetic.main.item_post_image.view.textViewShowComments
import kotlinx.android.synthetic.main.item_post_video.view.*
import java.util.*

class PostVideoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val imageViewProfile = itemView.imageViewProfile
    private val textViewProfileName = itemView.textViewProfileName
    private val recyclerViewPost = itemView.recyclerViewPost
    private val textViewPostViews = itemView.textViewPostViews
    private val textViewPostTime = itemView.textViewPostTime
    private val textViewAuthorComment = itemView.textViewAuthorComment
    private val textViewShowComments = itemView.textViewShowComments


    @SuppressLint("SetTextI18n")
    fun bind(post: Post){

        val context = itemView.context
        Picasso.get()
            .load(post.profileImageUrl)
            .placeholder(R.drawable.ic_avatar)
            .into(imageViewProfile)

        if(post.hasNewStory){
            imageViewProfile.borderWidth = context.resources.getDimension(R.dimen.story_border_width).toInt()
            imageViewProfile.borderColor = context.resources.getColor(R.color.story_border_color)
        }
        textViewPostViews.text = "${(post.postType as Posts.PostVideo).views} ${context.getString(R.string.views)}"


        if (post.postTimestamp == null){
            textViewPostTime.text = context.getString(R.string.time_not_defined)
        }else{
            textViewPostTime.text = DateUtils.getRelativeTimeSpanString(post.postTimestamp, Date().time, 0)
        }

        if(post.authorComment != null){
            val spannableProfileName = SpannableString(post.profileName)
            spannableProfileName.setSpan(ForegroundColorSpan(context.resources.getColor(android.R.color.black)), 0, spannableProfileName.length, 0)
            spannableProfileName.setSpan(StyleSpan(Typeface.BOLD), 0, spannableProfileName.length, 0)

            val spannableAuthorComment = SpannableString(post.authorComment)
            spannableAuthorComment.setSpan(ForegroundColorSpan(context.resources.getColor(android.R.color.black)), 0, spannableAuthorComment.length, 0)
            spannableAuthorComment.setSpan(StyleSpan(Typeface.NORMAL), 0, spannableAuthorComment.length, 0)

            val allAuthorComment = TextUtils.concat(spannableProfileName, " ", spannableAuthorComment)
            textViewAuthorComment.text = allAuthorComment
        }else{
            textViewAuthorComment.visibility = View.GONE
        }

        textViewShowComments.text = "${context.getString(R.string.show_all_comments)} (${post.postComments})"

        textViewProfileName.text = post.profileName

        recyclerViewPost.isNestedScrollingEnabled = false
        recyclerViewPost.setHasFixedSize(true)
        recyclerViewPost.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
        recyclerViewPost.adapter = PostImagesAdapter(urls = (post.postType as Posts.PostVideo).videosUrls, postType = post.postType!!)
        recyclerViewPost.onFlingListener = null
        PagerSnapHelper().attachToRecyclerView(recyclerViewPost)
    }

}