package com.egorsigolaev.alyaintstagram.app.activities

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.ActionBar
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.target.SimpleTarget
import com.bumptech.glide.request.transition.Transition
import com.egorsigolaev.alyaintstagram.R
import com.egorsigolaev.alyaintstagram.app.App.Companion.TAG
import com.egorsigolaev.alyaintstagram.app.adapters.PostsAdapter
import com.egorsigolaev.alyaintstagram.app.models.Post
import com.egorsigolaev.alyaintstagram.app.presenters.MainPresenter
import com.egorsigolaev.alyaintstagram.app.views.MainView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : MvpAppCompatActivity(), MainView {

    @InjectPresenter
    lateinit var presenter: MainPresenter
    lateinit var adapter: PostsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM;
        supportActionBar?.setCustomView(R.layout.custom_toolbar)

        adapter = PostsAdapter(posts = emptyList(), context = this)
        recyclerViewPosts.layoutManager = LinearLayoutManager(this)
        recyclerViewPosts.adapter = adapter
        //recyclerViewPosts.setHasFixedSize(true)
        presenter.loadPosts()
    }

    override fun startLoading() {
        Log.d(TAG, "startLoading")
    }

    override fun stopLoading() {
        Log.d(TAG, "stopLoading")
    }

    override fun showError(message: Int) {
        Log.d(TAG, "showError")
    }

    override fun showError(message: String) {
        Log.d(TAG, "showError")
    }

    override fun onPostsLoaded(posts: List<Post>) {
        Log.d(TAG, "onPostsLoaded")
        adapter.posts = posts
    }
}
