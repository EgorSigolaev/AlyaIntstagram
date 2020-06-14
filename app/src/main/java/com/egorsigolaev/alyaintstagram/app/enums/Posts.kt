package com.egorsigolaev.alyaintstagram.app.enums

sealed class Posts {
    class PostImage(val imagesUrls: List<String>, val likes: Int): Posts()   // пост - фото
    class PostVideo(val videosUrls: List<String>, val views: Int): Posts()   // пост - видео
    class AdvertImage(val imagesUrls: List<String>, val likes: Int): Posts() // реклама - фото
    class AdvertVideo(val videosUrls: List<String>, val views: Int): Posts() // реклама - видео
}