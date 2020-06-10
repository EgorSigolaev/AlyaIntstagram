package com.egorsigolaev.alyaintstagram.app.models

import com.egorsigolaev.alyaintstagram.app.enums.POST_TYPE

data class Post (
    val profile_name: String? = null,
    val profile_image_url: String? = null,
    val post_images: List<PostImage> = emptyList(),
    val post_likes: Int? = null,
    val post_comments: Int? = null,
    val author_comment: String? = null,
    val post_timestamp: Long? = null,
    val hasNewStory: Boolean = false,
    var post_type: Int = POST_TYPE.POST_IMAGE
)