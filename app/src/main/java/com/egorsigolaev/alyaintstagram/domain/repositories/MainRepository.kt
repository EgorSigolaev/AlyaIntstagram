package com.egorsigolaev.alyaintstagram.domain.repositories

import com.egorsigolaev.alyaintstagram.app.enums.Posts
import com.egorsigolaev.alyaintstagram.app.enums.Stories
import com.egorsigolaev.alyaintstagram.app.models.Post
import com.egorsigolaev.alyaintstagram.app.models.Profile
import com.egorsigolaev.alyaintstagram.app.models.Story
import io.reactivex.Single

class MainRepository {


    //симуляция целой базы данных (целая лента новостей)
    fun getAllPosts(): Single<List<Post>> {

        return Single.create {
            val urls = listOf(
                "https://images.squarespace-cdn.com/content/v1/585174d6893fc0a6ea9567ab/1537342711785-C9MX8CK9KB57B9G01VM5/ke17ZwdGBToddI8pDm48kKKPzNC1pd5EwhDtJFdEcXoUqsxRUqqbr1mOJYKfIPR7LoDQ9mXPOjoJoqy81S2I8PaoYXhp6HxIwZIk7-Mi3Tsic-L2IOPH3Dwrhl-Ne3Z2mxGOWoiEtYlj1y8uCs380-4Wg86iwZgYfMpFyqLFaCUKMshLAGzx4R3EDFOm1kBS/Screen+Shot+2018-09-19+at+08.37.59.png?format=1500w",
                "https://i.pinimg.com/474x/d5/45/a2/d545a2343d19f3ce8af9e9aa52dd3fce--travel-inspiration-beautiful-places.jpg",
                "https://baku-magazine.com/wp-content/uploads/2018/05/Screen-Shot-2018-05-02-at-9.16.36-AM-1.png",
                "https://baku-magazine.com/wp-content/uploads/2018/05/Screen-Shot-2018-05-02-at-9.16.36-AM-1.png",
                "https://baku-magazine.com/wp-content/uploads/2018/05/Screen-Shot-2018-05-02-at-9.16.36-AM-1.png",
                "https://baku-magazine.com/wp-content/uploads/2018/05/Screen-Shot-2018-05-02-at-9.16.36-AM-1.png",
                "https://baku-magazine.com/wp-content/uploads/2018/05/Screen-Shot-2018-05-02-at-9.16.36-AM-1.png",
                "https://baku-magazine.com/wp-content/uploads/2018/05/Screen-Shot-2018-05-02-at-9.16.36-AM-1.png"

            )

        val post1 = Post(
            id = 0,
            profileName = "username",
            profileImageUrl = "https://instagram.fods2-1.fna.fbcdn.net/v/t51.2885-19/s320x320/37735926_1396421363835870_7107451605296873472_n.jpg?_nc_ht=instagram.fods2-1.fna.fbcdn.net&_nc_ohc=dbP1VK-VPIsAX-ALdE7&oh=84057bc1c7fff5a9b2b364e5761603c3&oe=5F0D5CA9",
            postComments = 2,
            authorComment = "Немного текста по поводу статьи. Она очень интересная, замечательная, крутая! Топ, топ, топ, топ!",
            postTimestamp = 1592074546000,
            hasNewStory = true,
            postType = Posts.PostImage(urls, likes = 12)
        )
        val post2 = Post(
            id = 1,
            profileName = "username",
            profileImageUrl = "https://instagram.fods2-1.fna.fbcdn.net/v/t51.2885-19/s320x320/37735926_1396421363835870_7107451605296873472_n.jpg?_nc_ht=instagram.fods2-1.fna.fbcdn.net&_nc_ohc=dbP1VK-VPIsAX-ALdE7&oh=84057bc1c7fff5a9b2b364e5761603c3&oe=5F0D5CA9",
            postComments = 2,
            authorComment = "Author comment",
            postTimestamp = 1592074546000,
            hasNewStory = false,
            postType = Posts.PostVideo(listOf("https://videocdn.bodybuilding.com/video/mp4/62000/62792m.mp4", "https://videocdn.bodybuilding.com/video/mp4/62000/62792m.mp4"), views = 12342)
        )
        val post3 = Post(
            id = 2,
            profileName = "username",
            profileImageUrl = "https://instagram.fods2-1.fna.fbcdn.net/v/t51.2885-19/s320x320/37735926_1396421363835870_7107451605296873472_n.jpg?_nc_ht=instagram.fods2-1.fna.fbcdn.net&_nc_ohc=dbP1VK-VPIsAX-ALdE7&oh=84057bc1c7fff5a9b2b364e5761603c3&oe=5F0D5CA9",
            postComments = 2,
            authorComment = "Author comment",
            postTimestamp = 1592074546000,
            hasNewStory = false,
            postType = Posts.AdvertImage(urls, likes = 12)
        )
        val post4 = Post(
            id = 3,
            profileName = "username",
            profileImageUrl = "https://instagram.fods2-1.fna.fbcdn.net/v/t51.2885-19/s320x320/37735926_1396421363835870_7107451605296873472_n.jpg?_nc_ht=instagram.fods2-1.fna.fbcdn.net&_nc_ohc=dbP1VK-VPIsAX-ALdE7&oh=84057bc1c7fff5a9b2b364e5761603c3&oe=5F0D5CA9",
            postComments = 2,
            authorComment = "Author comment",
            postTimestamp = 1592074546000,
            hasNewStory = false,
            postType = Posts.AdvertVideo(listOf("https://videocdn.bodybuilding.com/video/mp4/62000/62792m.mp4", "https://videocdn.bodybuilding.com/video/mp4/62000/62792m.mp4"), views = 12345)
        )
        val post5 = Post(
            profileName = "username",
            profileImageUrl = "https://instagram.fods2-1.fna.fbcdn.net/v/t51.2885-19/s320x320/37735926_1396421363835870_7107451605296873472_n.jpg?_nc_ht=instagram.fods2-1.fna.fbcdn.net&_nc_ohc=dbP1VK-VPIsAX-ALdE7&oh=84057bc1c7fff5a9b2b364e5761603c3&oe=5F0D5CA9",
            postComments = 2,
            authorComment = "Author comment",
            postTimestamp = 1592074546000,
            hasNewStory = false,
            postType = Posts.PostImage(urls, likes = 12)
        )
        val post6 = Post(
            profileName = "username",
            profileImageUrl = "https://instagram.fods2-1.fna.fbcdn.net/v/t51.2885-19/s320x320/37735926_1396421363835870_7107451605296873472_n.jpg?_nc_ht=instagram.fods2-1.fna.fbcdn.net&_nc_ohc=dbP1VK-VPIsAX-ALdE7&oh=84057bc1c7fff5a9b2b364e5761603c3&oe=5F0D5CA9",

            postComments = 2,
            authorComment = "Author comment",
            postTimestamp = 1592074546000,
            hasNewStory = false,
            postType = Posts.PostImage(urls, likes = 12)
        )
        val post7 = Post(
            profileName = "username",
            profileImageUrl = "https://instagram.fods2-1.fna.fbcdn.net/v/t51.2885-19/s320x320/37735926_1396421363835870_7107451605296873472_n.jpg?_nc_ht=instagram.fods2-1.fna.fbcdn.net&_nc_ohc=dbP1VK-VPIsAX-ALdE7&oh=84057bc1c7fff5a9b2b364e5761603c3&oe=5F0D5CA9",
            postComments = 2,
            authorComment = "Author comment",
            postTimestamp = 1592074546000,
            hasNewStory = false,
            postType = Posts.PostImage(urls, likes = 12)
        )
        val post8 = Post(
            profileName = "username",
            profileImageUrl = "https://instagram.fods2-1.fna.fbcdn.net/v/t51.2885-19/s320x320/37735926_1396421363835870_7107451605296873472_n.jpg?_nc_ht=instagram.fods2-1.fna.fbcdn.net&_nc_ohc=dbP1VK-VPIsAX-ALdE7&oh=84057bc1c7fff5a9b2b364e5761603c3&oe=5F0D5CA9",
            postComments = 2,
            authorComment = "Author comment",
            postTimestamp = 1592074546000,
            hasNewStory = false,
            postType = Posts.AdvertImage(urls, likes = 12)
        )
        val post9 = Post(
            profileName = "username",
            profileImageUrl = "https://instagram.fods2-1.fna.fbcdn.net/v/t51.2885-19/s320x320/37735926_1396421363835870_7107451605296873472_n.jpg?_nc_ht=instagram.fods2-1.fna.fbcdn.net&_nc_ohc=dbP1VK-VPIsAX-ALdE7&oh=84057bc1c7fff5a9b2b364e5761603c3&oe=5F0D5CA9",
            postComments = 2,
            authorComment = "Author comment",
            postTimestamp = 1592074546000,
            hasNewStory = false,
            postType = Posts.PostImage(urls, likes = 12)
        )
        val post10 = Post(
            profileName = "username",
            profileImageUrl = "https://instagram.fods2-1.fna.fbcdn.net/v/t51.2885-19/s320x320/37735926_1396421363835870_7107451605296873472_n.jpg?_nc_ht=instagram.fods2-1.fna.fbcdn.net&_nc_ohc=dbP1VK-VPIsAX-ALdE7&oh=84057bc1c7fff5a9b2b364e5761603c3&oe=5F0D5CA9",
            postComments = 2,
            authorComment = "Author comment",
            postTimestamp = 1592074546000,
            hasNewStory = false,
            postType = Posts.PostImage(urls, likes = 12)
        )
        val post11 = Post(
            profileName = "username",
            profileImageUrl = "https://instagram.fods2-1.fna.fbcdn.net/v/t51.2885-19/s320x320/37735926_1396421363835870_7107451605296873472_n.jpg?_nc_ht=instagram.fods2-1.fna.fbcdn.net&_nc_ohc=dbP1VK-VPIsAX-ALdE7&oh=84057bc1c7fff5a9b2b364e5761603c3&oe=5F0D5CA9",
            postComments = 2,
            authorComment = "Author comment",
            postTimestamp = 1592074546000,
            hasNewStory = false,
            postType = Posts.PostImage(urls, likes = 12)
        )
        val post12 = Post(
            profileName = "username",
            profileImageUrl = "https://instagram.fods2-1.fna.fbcdn.net/v/t51.2885-19/s320x320/37735926_1396421363835870_7107451605296873472_n.jpg?_nc_ht=instagram.fods2-1.fna.fbcdn.net&_nc_ohc=dbP1VK-VPIsAX-ALdE7&oh=84057bc1c7fff5a9b2b364e5761603c3&oe=5F0D5CA9",
            postComments = 2,
            authorComment = "Author comment",
            postTimestamp = 1592074546000,
            hasNewStory = false,
            postType = Posts.AdvertImage(urls, likes = 12)
        )
        val post13 = Post(
            profileName = "username",
            profileImageUrl = "https://instagram.fods2-1.fna.fbcdn.net/v/t51.2885-19/s320x320/37735926_1396421363835870_7107451605296873472_n.jpg?_nc_ht=instagram.fods2-1.fna.fbcdn.net&_nc_ohc=dbP1VK-VPIsAX-ALdE7&oh=84057bc1c7fff5a9b2b364e5761603c3&oe=5F0D5CA9",
            postComments = 2,
            authorComment = "Author comment",
            postTimestamp = 1592074546000,
            hasNewStory = false,
            postType = Posts.PostImage(urls, likes = 12)
        )
        val post14 = Post(
            profileName = "username",
            profileImageUrl = "https://instagram.fods2-1.fna.fbcdn.net/v/t51.2885-19/s320x320/37735926_1396421363835870_7107451605296873472_n.jpg?_nc_ht=instagram.fods2-1.fna.fbcdn.net&_nc_ohc=dbP1VK-VPIsAX-ALdE7&oh=84057bc1c7fff5a9b2b364e5761603c3&oe=5F0D5CA9",
            postComments = 2,
            authorComment = "Author comment",
            postTimestamp = 1592074546000,
            hasNewStory = false,
            postType = Posts.PostImage(urls, likes = 12)
        )
        val post15 = Post(
            profileName = "username",
            profileImageUrl = "https://instagram.fods2-1.fna.fbcdn.net/v/t51.2885-19/s320x320/37735926_1396421363835870_7107451605296873472_n.jpg?_nc_ht=instagram.fods2-1.fna.fbcdn.net&_nc_ohc=dbP1VK-VPIsAX-ALdE7&oh=84057bc1c7fff5a9b2b364e5761603c3&oe=5F0D5CA9",
            postComments = 2,
            authorComment = "Author comment",
            postTimestamp = 1592074546000,
            hasNewStory = false,
            postType = Posts.PostVideo(listOf("https://videocdn.bodybuilding.com/video/mp4/62000/62792m.mp4", "https://videocdn.bodybuilding.com/video/mp4/62000/62792m.mp4"), views = 12345)
        )
        val post16 = Post(
            profileName = "username",
            profileImageUrl = "https://instagram.fods2-1.fna.fbcdn.net/v/t51.2885-19/s320x320/37735926_1396421363835870_7107451605296873472_n.jpg?_nc_ht=instagram.fods2-1.fna.fbcdn.net&_nc_ohc=dbP1VK-VPIsAX-ALdE7&oh=84057bc1c7fff5a9b2b364e5761603c3&oe=5F0D5CA9",
            postComments = 2,
            authorComment = "Author comment",
            postTimestamp = 1592074546000,
            hasNewStory = false,
            postType = Posts.PostImage(urls, likes = 12)
        )
        val post17 = Post(
            profileName = "username",
            profileImageUrl = "https://instagram.fods2-1.fna.fbcdn.net/v/t51.2885-19/s320x320/37735926_1396421363835870_7107451605296873472_n.jpg?_nc_ht=instagram.fods2-1.fna.fbcdn.net&_nc_ohc=dbP1VK-VPIsAX-ALdE7&oh=84057bc1c7fff5a9b2b364e5761603c3&oe=5F0D5CA9",
            postComments = 2,
            authorComment = "Author comment",
            postTimestamp = 1592074546000,
            hasNewStory = false,
            postType = Posts.AdvertVideo(listOf("https://videocdn.bodybuilding.com/video/mp4/62000/62792m.mp4", "https://videocdn.bodybuilding.com/video/mp4/62000/62792m.mp4"), views = 12345)
        )
        val post18 = Post(
            profileName = "username",
            profileImageUrl = "https://instagram.fods2-1.fna.fbcdn.net/v/t51.2885-19/s320x320/37735926_1396421363835870_7107451605296873472_n.jpg?_nc_ht=instagram.fods2-1.fna.fbcdn.net&_nc_ohc=dbP1VK-VPIsAX-ALdE7&oh=84057bc1c7fff5a9b2b364e5761603c3&oe=5F0D5CA9",
            postComments = 2,
            authorComment = "Author comment",
            postTimestamp = 1592074546000,
            hasNewStory = false,
            postType = Posts.PostImage(urls, likes = 12)
        )
        val post19 = Post(
            profileName = "username",
            profileImageUrl = "https://instagram.fods2-1.fna.fbcdn.net/v/t51.2885-19/s320x320/37735926_1396421363835870_7107451605296873472_n.jpg?_nc_ht=instagram.fods2-1.fna.fbcdn.net&_nc_ohc=dbP1VK-VPIsAX-ALdE7&oh=84057bc1c7fff5a9b2b364e5761603c3&oe=5F0D5CA9",
            postComments = 2,
            authorComment = "Author comment",
            postTimestamp = 1592074546000,
            hasNewStory = false,
            postType = Posts.PostVideo(listOf("https://videocdn.bodybuilding.com/video/mp4/62000/62792m.mp4", "https://videocdn.bodybuilding.com/video/mp4/62000/62792m.mp4"), views = 12345)
        )
        val post20 = Post(
            profileName = "username",
            profileImageUrl = "https://instagram.fods2-1.fna.fbcdn.net/v/t51.2885-19/s320x320/37735926_1396421363835870_7107451605296873472_n.jpg?_nc_ht=instagram.fods2-1.fna.fbcdn.net&_nc_ohc=dbP1VK-VPIsAX-ALdE7&oh=84057bc1c7fff5a9b2b364e5761603c3&oe=5F0D5CA9",
            postComments = 2,
            authorComment = "Author comment",
            postTimestamp = 1592074546000,
            hasNewStory = false,
            postType = Posts.AdvertVideo(listOf("https://videocdn.bodybuilding.com/video/mp4/62000/62792m.mp4", "https://videocdn.bodybuilding.com/video/mp4/62000/62792m.mp4"), views = 12345)
        )
        val post21 = Post(
            profileName = "username",
            profileImageUrl = "https://instagram.fods2-1.fna.fbcdn.net/v/t51.2885-19/s320x320/37735926_1396421363835870_7107451605296873472_n.jpg?_nc_ht=instagram.fods2-1.fna.fbcdn.net&_nc_ohc=dbP1VK-VPIsAX-ALdE7&oh=84057bc1c7fff5a9b2b364e5761603c3&oe=5F0D5CA9",
            postComments = 2,
            authorComment = "Author comment",
            postTimestamp = 1592074546000,
            hasNewStory = false,
            postType = Posts.PostVideo(listOf("https://videocdn.bodybuilding.com/video/mp4/62000/62792m.mp4", "https://videocdn.bodybuilding.com/video/mp4/62000/62792m.mp4"), views = 12345)
        )

        it.onSuccess(listOf(post1, post2, post3, post4,post5, post6, post7, post8,post9, post10, post11, post12,post13, post14, post15, post16,post17, post18, post19, post20, post21))
        }
    }

    fun getPosts(startIndex: Int, loadSize: Int): Single<List<Post>>{

        return Single.create { emitter ->
            getAllPosts().subscribe({
                val list = mutableListOf<Post>()

                if(startIndex + 1 + loadSize > it.size){
                    val newLoadSize = it.size - startIndex
                    for (i in 0 until newLoadSize){
                        list.add(it[startIndex + i])
                    }
                    emitter.onSuccess(list)
                }else{
                    for (i in 0 until loadSize){
                        list.add(it[startIndex + i])
                    }
                    emitter.onSuccess(list)
                }

            }, {})
        }

    }


    fun getAllStories(): Single<List<Story>>{
        return Single.create {
            val story1 = Story(
                profileImageUrl = "https://instagram.fods2-1.fna.fbcdn.net/v/t51.2885-19/s320x320/37735926_1396421363835870_7107451605296873472_n.jpg?_nc_ht=instagram.fods2-1.fna.fbcdn.net&_nc_ohc=dbP1VK-VPIsAX-ALdE7&oh=84057bc1c7fff5a9b2b364e5761603c3&oe=5F0D5CA9",
                hasUncheckedStory = false,
                storyType = Stories.MY_STORY
            )
            val story2 = Story(
                profileName = "profile_name2",
                profileImageUrl = "https://instagram.fods2-1.fna.fbcdn.net/v/t51.2885-19/s320x320/37735926_1396421363835870_7107451605296873472_n.jpg?_nc_ht=instagram.fods2-1.fna.fbcdn.net&_nc_ohc=dbP1VK-VPIsAX-ALdE7&oh=84057bc1c7fff5a9b2b364e5761603c3&oe=5F0D5CA9",
                hasUncheckedStory = true
            )
            val story3 = Story(
                profileName = "profile_name3",
                profileImageUrl = "https://instagram.fods2-1.fna.fbcdn.net/v/t51.2885-19/s320x320/37735926_1396421363835870_7107451605296873472_n.jpg?_nc_ht=instagram.fods2-1.fna.fbcdn.net&_nc_ohc=dbP1VK-VPIsAX-ALdE7&oh=84057bc1c7fff5a9b2b364e5761603c3&oe=5F0D5CA9",
                hasUncheckedStory = true
            )
            val story4 = Story(
                profileName = "profile_name4",
                profileImageUrl = "https://instagram.fods2-1.fna.fbcdn.net/v/t51.2885-19/s320x320/37735926_1396421363835870_7107451605296873472_n.jpg?_nc_ht=instagram.fods2-1.fna.fbcdn.net&_nc_ohc=dbP1VK-VPIsAX-ALdE7&oh=84057bc1c7fff5a9b2b364e5761603c3&oe=5F0D5CA9",
                hasUncheckedStory = true
            )
            val story5 = Story(
                profileName = "profile_name5",
                profileImageUrl = "https://instagram.fods2-1.fna.fbcdn.net/v/t51.2885-19/s320x320/37735926_1396421363835870_7107451605296873472_n.jpg?_nc_ht=instagram.fods2-1.fna.fbcdn.net&_nc_ohc=dbP1VK-VPIsAX-ALdE7&oh=84057bc1c7fff5a9b2b364e5761603c3&oe=5F0D5CA9",
                hasUncheckedStory = true
            )
            val story6 = Story(
                profileName = "profile_name6",
                profileImageUrl = "https://instagram.fods2-1.fna.fbcdn.net/v/t51.2885-19/s320x320/37735926_1396421363835870_7107451605296873472_n.jpg?_nc_ht=instagram.fods2-1.fna.fbcdn.net&_nc_ohc=dbP1VK-VPIsAX-ALdE7&oh=84057bc1c7fff5a9b2b364e5761603c3&oe=5F0D5CA9",
                hasUncheckedStory = true
            )
            val story7 = Story(
                profileName = "profile_name7",
                profileImageUrl = "https://instagram.fods2-1.fna.fbcdn.net/v/t51.2885-19/s320x320/37735926_1396421363835870_7107451605296873472_n.jpg?_nc_ht=instagram.fods2-1.fna.fbcdn.net&_nc_ohc=dbP1VK-VPIsAX-ALdE7&oh=84057bc1c7fff5a9b2b364e5761603c3&oe=5F0D5CA9",
                hasUncheckedStory = false
            )
            val story8 = Story(
                profileName = "profile_name8",
                profileImageUrl = "https://instagram.fods2-1.fna.fbcdn.net/v/t51.2885-19/s320x320/37735926_1396421363835870_7107451605296873472_n.jpg?_nc_ht=instagram.fods2-1.fna.fbcdn.net&_nc_ohc=dbP1VK-VPIsAX-ALdE7&oh=84057bc1c7fff5a9b2b364e5761603c3&oe=5F0D5CA9",
                hasUncheckedStory = false
            )
            val story9 = Story(
                profileName = "profile_name9",
                profileImageUrl = "https://instagram.fods2-1.fna.fbcdn.net/v/t51.2885-19/s320x320/37735926_1396421363835870_7107451605296873472_n.jpg?_nc_ht=instagram.fods2-1.fna.fbcdn.net&_nc_ohc=dbP1VK-VPIsAX-ALdE7&oh=84057bc1c7fff5a9b2b364e5761603c3&oe=5F0D5CA9",
                hasUncheckedStory = true
            )
            val story10 = Story(
                profileName = "profile_name10",
                profileImageUrl = "https://instagram.fods2-1.fna.fbcdn.net/v/t51.2885-19/s320x320/37735926_1396421363835870_7107451605296873472_n.jpg?_nc_ht=instagram.fods2-1.fna.fbcdn.net&_nc_ohc=dbP1VK-VPIsAX-ALdE7&oh=84057bc1c7fff5a9b2b364e5761603c3&oe=5F0D5CA9",
                hasUncheckedStory = false
            )

            it.onSuccess(listOf(story1, story2, story3, story4, story5, story6, story7, story8, story9, story10))
        }
    }

    fun getProfile(): Single<Profile>{
        return Single.create {
            val profile = Profile(username = "egor_sigolaev", profileImageUrl = "https://instagram.fods2-1.fna.fbcdn.net/v/t51.2885-19/s320x320/37735926_1396421363835870_7107451605296873472_n.jpg?_nc_ht=instagram.fods2-1.fna.fbcdn.net&_nc_ohc=dbP1VK-VPIsAX-ALdE7&oh=84057bc1c7fff5a9b2b364e5761603c3&oe=5F0D5CA9")
            it.onSuccess(profile)
        }
    }
}
