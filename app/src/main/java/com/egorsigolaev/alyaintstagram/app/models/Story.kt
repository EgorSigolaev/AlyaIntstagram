package com.egorsigolaev.alyaintstagram.app.models

import com.egorsigolaev.alyaintstagram.app.enums.Stories

data class Story (
    val id: Int? = null,
    val profile_name: String? = null,
    val profile_image_url: String? = null,
    val has_unchecked_story: Boolean = false,
    val story_type: Int = Stories.DEFAULT
)