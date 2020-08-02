package com.egorsigolaev.alyaintstagram.domain.repositories

import android.content.Context
import android.graphics.Typeface
import android.text.SpannableString
import android.text.TextUtils
import android.text.format.DateUtils
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import com.egorsigolaev.alyaintstagram.R
import com.egorsigolaev.alyaintstagram.app.App
import com.egorsigolaev.alyaintstagram.app.enums.Posts
import com.egorsigolaev.alyaintstagram.app.models.Post
import java.util.*
import javax.inject.Inject

class PostsMapper {

    @Inject lateinit var context: Context

    init {
        App.appComponent.inject(this)
    }

    fun map(posts: List<Post>): List<Post>{
        val mappedPosts = mutableListOf<Post>()
        for(post in posts){
            if (post.hasNewStory) {
                post.storyBorderWidth = context.resources.getDimension(R.dimen.story_border_width).toInt()
                post.storyBorderColor = context.resources.getColor(R.color.story_border_color)
            }
            when(post.postType){
                is Posts.PostImage -> post.likesText = "${context.getString(R.string.like)}: ${(post.postType as Posts.PostImage).likes}"
                is Posts.PostVideo ->  post.viewsText = "${(post.postType as Posts.PostVideo).views} ${context.getString(R.string.views)}"
            }
            if (post.postTimestamp == null) {
                post.timeText = context.getString(R.string.time_not_defined)
            } else {
                post.timeText = DateUtils.getRelativeTimeSpanString(post.postTimestamp, Date().time, 0).toString()
            }
            post.commentsText = "${context.getString(R.string.show_all_comments)} (${post.postComments})"
            post.allAuthorComment = getAuthorCommentSpannable(post = post)


            mappedPosts.add(post)
        }
        return mappedPosts
    }

    private fun getAuthorCommentSpannable(post: Post): CharSequence?{
        if (post.authorComment != null) {
            val spannableProfileName = SpannableString(post.profileName)
            spannableProfileName.setSpan(
                ForegroundColorSpan(context.resources.getColor(android.R.color.black)),
                0,
                spannableProfileName.length,
                0
            )
            spannableProfileName.setSpan(
                StyleSpan(Typeface.BOLD),
                0,
                spannableProfileName.length,
                0
            )

            val spannableAuthorComment = SpannableString(post.authorComment)
            spannableAuthorComment.setSpan(
                ForegroundColorSpan(
                    context.resources.getColor(
                        android.R.color.black
                    )
                ), 0, spannableAuthorComment.length, 0
            )
            spannableAuthorComment.setSpan(
                StyleSpan(Typeface.NORMAL),
                0,
                spannableAuthorComment.length,
                0
            )

            return TextUtils.concat(spannableProfileName, " ", spannableAuthorComment)
        }
        return null
    }

}