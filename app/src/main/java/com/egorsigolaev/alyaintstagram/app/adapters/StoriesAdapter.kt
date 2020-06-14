package com.egorsigolaev.alyaintstagram.app.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.egorsigolaev.alyaintstagram.R
import com.egorsigolaev.alyaintstagram.app.enums.Stories
import com.egorsigolaev.alyaintstagram.app.models.Story
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_my_story.view.*
import kotlinx.android.synthetic.main.item_story.view.imageViewProfile
import kotlinx.android.synthetic.main.item_story.view.textViewProfileName

class StoriesAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var stories = emptyList<Story>()
    set(value) {
        notifyDataSetChanged()
        field = value
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when(viewType){
            Stories.DEFAULT -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_story, parent, false)
                return DefaultStoryHolder(view)
            }
            Stories.MY_STORY -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_my_story, parent, false)
                return MyStoryHolder(view)
            }
        }
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_story, parent, false)
        return DefaultStoryHolder(view)
    }

    override fun getItemCount(): Int {
        return stories.size
    }

    override fun getItemViewType(position: Int): Int {
        return stories[position].story_type
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(getItemViewType(position)){
            Stories.DEFAULT -> (holder as DefaultStoryHolder).bind(stories[position])
            Stories.MY_STORY -> (holder as MyStoryHolder).bind(stories[position])
        }
    }

    inner class DefaultStoryHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textViewProfileName = itemView.textViewProfileName
        private val imageViewProfile = itemView.imageViewProfile

        fun bind(story: Story){
            val context = itemView.context
            if(story.has_unchecked_story){
                imageViewProfile.borderWidth = context.resources.getDimension(R.dimen.story_border_width).toInt()
                imageViewProfile.borderColor = context.resources.getColor(R.color.story_border_color)
            }
            Picasso.get()
                .load(story.profile_image_url)
                .placeholder(R.color.grey)
                .into(imageViewProfile)

            textViewProfileName.text = story.profile_name
        }
    }

    inner class MyStoryHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private val textViewProfileName = itemView.textViewProfileName
        private val imageViewProfile = itemView.imageViewMyProfile
        private val imageViewAddStory = itemView.imageViewAddStory

        fun bind(story: Story){
            val context = itemView.context
            if(story.has_unchecked_story){
                imageViewProfile.borderWidth = context.resources.getDimension(R.dimen.story_border_width).toInt()
                imageViewProfile.borderColor = context.resources.getColor(R.color.story_border_color)
                imageViewAddStory.visibility = View.INVISIBLE
            }
            Picasso.get()
                .load(story.profile_image_url)
                .placeholder(R.color.grey)
                .into(imageViewProfile)
            textViewProfileName.text = context.getString(R.string.your_story)
        }
    }

}