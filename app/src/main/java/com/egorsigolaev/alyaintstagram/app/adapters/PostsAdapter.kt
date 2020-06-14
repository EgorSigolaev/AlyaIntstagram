package com.egorsigolaev.alyaintstagram.app.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedList
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.egorsigolaev.alyaintstagram.app.App
import com.egorsigolaev.alyaintstagram.app.activities.MainActivity
import com.egorsigolaev.alyaintstagram.app.enums.Posts
import com.egorsigolaev.alyaintstagram.app.interfaces.PagingListener
import com.egorsigolaev.alyaintstagram.app.models.Post
import com.egorsigolaev.alyaintstagram.app.view_holders.AdvertImageViewHolder
import com.egorsigolaev.alyaintstagram.app.view_holders.AdvertVideoViewHolder
import com.egorsigolaev.alyaintstagram.app.view_holders.PostImageViewHolder
import com.egorsigolaev.alyaintstagram.app.view_holders.PostVideoViewHolder
import com.egorsigolaev.alyaintstagram.data.datasource.PostsDataSource
import com.egorsigolaev.alyaintstagram.domain.repositories.MainRepository
import java.util.concurrent.Executors


class PostsAdapter : PagedListAdapter<Post, RecyclerView.ViewHolder>(ItemsDiffCallback), PagingListener{

    private val POST_IMAGE = 0
    private val POST_VIDEO = 1
    private val ADVERT_IMAGE = 2
    private val ADVERT_VIDEO = 3

    private var config: PagedList.Config
    private var pagedList: PagedList<Post>

    init {
        val dataSource = PostsDataSource(this)
        config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(App.INIT_PAGE_SIZE)
            .setPageSize(App.PAGE_SIZE)
            .build()

        pagedList = PagedList.Builder(dataSource, config)
            .setFetchExecutor(Executors.newSingleThreadExecutor())
            .setNotifyExecutor(MainActivity.MainThreadExecutor())
            .build()

        submitList(pagedList)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when(viewType){
            POST_IMAGE -> {
                val view = LayoutInflater.from(parent.context).inflate(com.egorsigolaev.alyaintstagram.R.layout.item_post_image, parent, false)
                return PostImageViewHolder(view)
            }
            POST_VIDEO -> {
                val view = LayoutInflater.from(parent.context).inflate(com.egorsigolaev.alyaintstagram.R.layout.item_post_video, parent, false)
                return PostVideoViewHolder(view)
            }
            ADVERT_IMAGE -> {
                val view = LayoutInflater.from(parent.context).inflate(com.egorsigolaev.alyaintstagram.R.layout.item_advert_image, parent, false)
                return AdvertImageViewHolder(view)
            }
            ADVERT_VIDEO -> {
                val view = LayoutInflater.from(parent.context).inflate(com.egorsigolaev.alyaintstagram.R.layout.item_advert_video, parent, false)
                return AdvertVideoViewHolder(view)
            }
        }
        val view =  LayoutInflater.from(parent.context).inflate(com.egorsigolaev.alyaintstagram.R.layout.item_post_image, parent, false)
        return PostImageViewHolder(view)
    }

    override fun getItemViewType(position: Int): Int {
        return when(getItem(position)?.postType){
            is Posts.PostImage -> POST_IMAGE
            is Posts.PostVideo -> POST_VIDEO
            is Posts.AdvertImage -> ADVERT_IMAGE
            is Posts.AdvertVideo -> ADVERT_VIDEO
            else -> -1
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(getItemViewType(position)){
            POST_IMAGE -> (holder as PostImageViewHolder).bind(post = getItem(position)!!)
            POST_VIDEO -> (holder as PostVideoViewHolder).bind(post = getItem(position)!!)
            ADVERT_IMAGE -> (holder as AdvertImageViewHolder).bind(post = getItem(position)!!)
            ADVERT_VIDEO -> (holder as AdvertVideoViewHolder).bind(post = getItem(position)!!)
        }
    }

    companion object {
        val ItemsDiffCallback = object : DiffUtil.ItemCallback<Post>() {
            override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onPageStartLoading() {

    }

    override fun onPageLoaded() {

    }

}