package com.egorsigolaev.alyaintstagram.app.models

import android.graphics.Color
import com.egorsigolaev.alyaintstagram.app.enums.Posts

data class Post (
    val id: Int? = null,                 // id поста
    val profileName: String? = null,     // username хозяина поста
    val profileImageUrl: String? = null, // ссылка на фото хозяина поста
    val postComments: Int? = null,       // кол - во комментариев под постом
    val authorComment: String? = null,   // коммент автора
    val postTimestamp: Long? = null,     // timestamp времени публикации
    val hasNewStory: Boolean = false,    // есть - ли непросмотренная история для смотрящего пост
    var postType: Posts? = null,          // вид поста
    var storyBorderWidth: Int = 0,
    var storyBorderColor: Int = Color.WHITE,
    var likesText: String? = null,
    var viewsText: String? = null,
    var timeText: String? = null,
    var allAuthorComment: CharSequence? = null,
    var commentsText: String? = null
)