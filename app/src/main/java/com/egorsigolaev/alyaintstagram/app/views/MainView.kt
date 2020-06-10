package com.egorsigolaev.alyaintstagram.app.views

import com.arellomobile.mvp.MvpView
import com.egorsigolaev.alyaintstagram.app.adapters.PostsAdapter
import com.egorsigolaev.alyaintstagram.app.models.Post

interface MainView: MvpView {
    fun startLoading()
    fun stopLoading()
    fun showError(message: Int)
    fun showError(message: String)
    fun onPostsLoaded(posts: List<Post>)
}