package com.egorsigolaev.alyaintstagram.app.enums

sealed class Posts {
    class PostImage(val imagesUrls: List<String>, val likes: Int): Posts()   // пост - фото
    class PostVideo(val videosUrls: List<String>, val views: Int): Posts()   // пост - видео
}