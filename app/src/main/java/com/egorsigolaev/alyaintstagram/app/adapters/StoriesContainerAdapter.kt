package com.egorsigolaev.alyaintstagram.app.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.egorsigolaev.alyaintstagram.R
import com.egorsigolaev.alyaintstagram.app.models.Story
import kotlinx.android.synthetic.main.stories_container.view.*

class StoriesContainerAdapter: RecyclerView.Adapter<StoriesContainerAdapter.StoriesContainerHolder>() {

    var stories = emptyList<Story>()
        set(value) {
            notifyDataSetChanged()
            field = value
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoriesContainerHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.stories_container, parent, false)
        return StoriesContainerHolder(view)
    }

    override fun getItemCount(): Int {
        return 1
    }

    override fun onBindViewHolder(holder: StoriesContainerHolder, position: Int) {
        holder.bind()
    }

    inner class StoriesContainerHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val recyclerViewStories = itemView.recyclerViewStories

        fun bind(){
            val storiesAdapter = StoriesAdapter()
            storiesAdapter.stories = stories
            recyclerViewStories.layoutManager = LinearLayoutManager(itemView.context, LinearLayoutManager.HORIZONTAL, false)
            recyclerViewStories.setHasFixedSize(true)
            recyclerViewStories.adapter = storiesAdapter
        }
    }




}