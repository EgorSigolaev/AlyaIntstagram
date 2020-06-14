package com.egorsigolaev.alyaintstagram.app.activities

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSmoothScroller
import androidx.recyclerview.widget.MergeAdapter
import androidx.recyclerview.widget.RecyclerView.SmoothScroller
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.egorsigolaev.alyaintstagram.R
import com.egorsigolaev.alyaintstagram.app.App.Companion.TAG
import com.egorsigolaev.alyaintstagram.app.adapters.PostsAdapter
import com.egorsigolaev.alyaintstagram.app.adapters.StoriesContainerAdapter
import com.egorsigolaev.alyaintstagram.app.interfaces.PagingListener
import com.egorsigolaev.alyaintstagram.app.models.Post
import com.egorsigolaev.alyaintstagram.app.models.Profile
import com.egorsigolaev.alyaintstagram.app.models.Story
import com.egorsigolaev.alyaintstagram.app.presenters.MainPresenter
import com.egorsigolaev.alyaintstagram.app.views.MainView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.buttonBottomHome
import kotlinx.android.synthetic.main.activity_main.recyclerView
import kotlinx.android.synthetic.main.activity_main.refreshLayout
import java.util.concurrent.Executor


class MainActivity : MvpAppCompatActivity(), MainView {

    @InjectPresenter
    lateinit var presenter: MainPresenter
    private lateinit var postAdapter: PostsAdapter
    private lateinit var storiesContainerAdapter: StoriesContainerAdapter
    private lateinit var mergeAdapter: MergeAdapter
    private lateinit var smoothScroller: SmoothScroller

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        configureRefreshLayout()
        configureViews()
        configureRecyclerView()
        presenter.loadStories()
        presenter.loadProfileImageUrl()
    }

    private fun configureRefreshLayout(){
        refreshLayout.setOnRefreshListener {
            presenter.loadStories()
            presenter.loadPosts()
        }
    }

    private fun configureViews(){
        buttonBottomHome.setOnClickListener {
            scrollToTop()
        }
        smoothScroller = object : LinearSmoothScroller(applicationContext) {
            override fun getVerticalSnapPreference(): Int {
                return SNAP_TO_START
            }
        }
    }

    private fun configureRecyclerView(){
        storiesContainerAdapter = StoriesContainerAdapter()
        postAdapter = PostsAdapter()
        mergeAdapter = MergeAdapter(storiesContainerAdapter, postAdapter)
        recyclerView.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = mergeAdapter
        }
    }

    private fun scrollToTop() {
        Handler().post {
            smoothScroller.targetPosition = 0
            recyclerView.layoutManager?.startSmoothScroll(smoothScroller)
        }
    }

    internal class MainThreadExecutor : Executor {
        private val mHandler: Handler = Handler(Looper.getMainLooper())

        override fun execute(command: Runnable) {
            mHandler.post(command)
        }
    }

    override fun onPostsLoaded(posts: List<Post>) {
        mergeAdapter.notifyDataSetChanged()
        refreshLayout.setRefreshing(false)
    }

    override fun onStoriesLoaded(stories: List<Story>) {
        Log.d(TAG, "Stories loaded size: " + stories.size)
        storiesContainerAdapter.stories = stories
    }

    override fun onProfileLoaded(profile: Profile) {
        Log.d(TAG, "onProfileLoaded url: " + profile.profile_image_url)
        Picasso.get()
            .load(profile.profile_image_url)
            .into(imageViewMyProfile)
    }
}
