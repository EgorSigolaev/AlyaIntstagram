package com.egorsigolaev.alyaintstagram.app.presenters

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.egorsigolaev.alyaintstagram.R
import com.egorsigolaev.alyaintstagram.app.enums.POST_TYPE
import com.egorsigolaev.alyaintstagram.app.models.Post
import com.egorsigolaev.alyaintstagram.app.models.PostImage
import com.egorsigolaev.alyaintstagram.app.views.MainView

@InjectViewState
class MainPresenter: MvpPresenter<MainView>() {

    fun loadPosts(){
        val post1 = Post(
            profile_name = "Profile name",
            profile_image_url = "",
            post_images = listOf(PostImage(resId = R.drawable.photo_1), PostImage(resId = R.drawable.photo_2), PostImage(resId = R.drawable.photo_3)),
            post_likes = 12,
            post_comments = 2,
            author_comment = "Author comment",
            post_timestamp = 1591827300,
            hasNewStory = false,
            post_type = POST_TYPE.POST_IMAGE
        )
        val post2 = Post(
            profile_name = "Profile name",
            profile_image_url = "",
            post_images = listOf(PostImage(resId = R.drawable.photo_1), PostImage(resId = R.drawable.photo_2), PostImage(resId = R.drawable.photo_3)),
            post_likes = 12,
            post_comments = 2,
            author_comment = "Author comment",
            post_timestamp = 1591827300,
            hasNewStory = false,
            post_type = POST_TYPE.POST_IMAGE
        )
        val post3 = Post(
            profile_name = "Profile name",
            profile_image_url = "",
            post_images = listOf(PostImage(resId = R.drawable.photo_1), PostImage(resId = R.drawable.photo_2), PostImage(resId = R.drawable.photo_3)),
            post_likes = 12,
            post_comments = 2,
            author_comment = "Author comment",
            post_timestamp = 1591827300,
            hasNewStory = false,
            post_type = POST_TYPE.POST_IMAGE
        )
        val post4 = Post(
            profile_name = "Profile name",
            profile_image_url = "",
            post_images = listOf(PostImage(resId = R.drawable.photo_1), PostImage(resId = R.drawable.photo_2), PostImage(resId = R.drawable.photo_3)),
            post_likes = 12,
            post_comments = 2,
            author_comment = "Author comment",
            post_timestamp = 1591827300,
            hasNewStory = false,
            post_type = POST_TYPE.POST_IMAGE
        )

        viewState.onPostsLoaded(listOf(post1, post2, post3, post4))
    }

}