package com.egorsigolaev.alyaintstagram.app.models

import com.egorsigolaev.alyaintstagram.app.enums.Stories

data class Story (
    val id: Int? = null,
    val profileName: String? = null,
    val profileImageUrl: String? = null,
    val hasUncheckedStory: Boolean = false,
    val storyType: Int = Stories.DEFAULT
)