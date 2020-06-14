package com.egorsigolaev.alyaintstagram.app.views

import com.arellomobile.mvp.MvpView
import com.egorsigolaev.alyaintstagram.app.models.Post
import com.egorsigolaev.alyaintstagram.app.models.Profile
import com.egorsigolaev.alyaintstagram.app.models.Story

interface MainView: MvpView {
    fun onPostsLoaded(posts: List<Post>)
    fun onStoriesLoaded(stories: List<Story>)
    fun onProfileLoaded(profile: Profile)
}