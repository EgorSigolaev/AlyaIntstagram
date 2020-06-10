package com.egorsigolaev.alyaintstagram.app.adapters

import android.content.Context
import android.graphics.Typeface
import android.text.SpannableString
import android.text.TextUtils
import android.text.format.DateUtils
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.egorsigolaev.alyaintstagram.R
import com.egorsigolaev.alyaintstagram.app.enums.POST_TYPE
import com.egorsigolaev.alyaintstagram.app.models.Post
import kotlinx.android.synthetic.main.item_post_image_type.view.*


class PostsAdapter(var posts: List<Post>, private var context: Context): RecyclerView.Adapter<RecyclerView.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when(viewType){
            POST_TYPE.POST_IMAGE -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_post_image_type, parent, false)
                return PostImageViewHolder(view)
            }


        }
        val view =  LayoutInflater.from(parent.context).inflate(R.layout.item_post_image_type, parent, false)
        return PostImageViewHolder(view)
    }

    override fun getItemViewType(position: Int): Int {
        return posts[position].post_type
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val post = posts[position]
        when(getItemViewType(position = position)){
            POST_TYPE.POST_IMAGE -> (holder as PostImageViewHolder).bind(post = post)
            POST_TYPE.POST_VIDEO -> (holder as PostVideoViewHolder).bind(post = post)

        }
    }

    inner class PostImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageViewProfile = itemView.imageViewProfile
        private val textViewProfileName = itemView.textViewProfileName
        //private val buttonMoreAction = itemView.buttonMoreAction
        private val recyclerViewPost = itemView.recyclerViewPost
        private val textViewPostLikes = itemView.textViewPostLikes
        private val textViewPostTime = itemView.textViewPostTime
        private val textViewAuthorComment = itemView.textViewAuthorComment
        private val textViewShowComments = itemView.textViewShowComments


        fun bind(post: Post){
            if(post.hasNewStory){
                val layoutParams = ViewGroup.LayoutParams(context.resources.getDimensionPixelSize(R.dimen.story_border_width), 0)
                //imageViewProfile.borderWidth = context.resources.getDimension(R.dimen.story_border_width)
                imageViewProfile.layoutParams = layoutParams
            }
            textViewPostLikes.text = "Нравится: ${post.post_likes}"


            if (post.post_timestamp == null){
                textViewPostTime.text = "Время не определено"
            }else{
                textViewPostTime.text = DateUtils.getRelativeTimeSpanString(post.post_timestamp, System.currentTimeMillis(), DateUtils.MINUTE_IN_MILLIS)
            }

            var allAuthorComment: CharSequence = post.profile_name + " " + post.author_comment
            val profileName = allAuthorComment.split(" ")[0]
            val authorComment = allAuthorComment.split(" ")[1]

            val spannableProfileName = SpannableString(profileName)
            spannableProfileName.setSpan(ForegroundColorSpan(context.resources.getColor(android.R.color.black)), 0, spannableProfileName.length, 0)
            spannableProfileName.setSpan(StyleSpan(Typeface.BOLD), 0, spannableProfileName.length, 0)

            val spannableAuthorComment = SpannableString(authorComment)
            spannableAuthorComment.setSpan(ForegroundColorSpan(context.resources.getColor(android.R.color.black)), 0, spannableAuthorComment.length, 0)
            spannableAuthorComment.setSpan(StyleSpan(Typeface.NORMAL), 0, authorComment.length, 0)

            allAuthorComment = TextUtils.concat(spannableProfileName, " ", spannableAuthorComment)

            textViewAuthorComment.text = allAuthorComment

            textViewShowComments.text = "Просмотреть все комментарии (${post.post_comments})"

            textViewProfileName.text = post.profile_name

            recyclerViewPost.setHasFixedSize(true)
            recyclerViewPost.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
            recyclerViewPost.adapter = PostImagesAdapter(images = post.post_images)
            PagerSnapHelper().attachToRecyclerView(recyclerViewPost)
//            val postImagesAdapter = PostImagesAdapter(postImages = post.post_images, context = context)
//            postsViewPager.adapter = postImagesAdapter
        }

    }

    inner class PostVideoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageViewProfile = itemView.imageViewProfile
        private val textViewProfileName = itemView.textViewProfileName
        private val buttonMoreAction = itemView.buttonMoreAction
        //private val postsViewPager = itemView.postsViewPager

        fun bind(post: Post){
//            if(post.hasNewStory){
//                val layoutParams = ViewGroup.LayoutParams(context.resources.getDimensionPixelSize(R.dimen.story_border_width), 0)
//                //imageViewProfile.borderWidth = context.resources.getDimension(R.dimen.story_border_width)
//                imageViewProfile.layoutParams = layoutParams
//            }
//            textViewProfileName.text = post.profile_name
//            val postImagesAdapter = PostImagesAdapter(postImages = post.post_images, context = context)
//            postsViewPager.adapter = postImagesAdapter
        }
    }

}