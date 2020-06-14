package com.egorsigolaev.alyaintstagram.domain.repositories

import com.egorsigolaev.alyaintstagram.app.enums.Posts
import com.egorsigolaev.alyaintstagram.app.enums.Stories
import com.egorsigolaev.alyaintstagram.app.models.Post
import com.egorsigolaev.alyaintstagram.app.models.Profile
import com.egorsigolaev.alyaintstagram.app.models.Story
import io.reactivex.Single

class MainRepository {



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
            profileName = "egor_sigolaev",
            profileImageUrl = "https://instagram.fods2-1.fna.fbcdn.net/v/t51.2885-19/s320x320/37735926_1396421363835870_7107451605296873472_n.jpg?_nc_ht=instagram.fods2-1.fna.fbcdn.net&_nc_ohc=dbP1VK-VPIsAX-ALdE7&oh=84057bc1c7fff5a9b2b364e5761603c3&oe=5F0D5CA9",
            postComments = 2,
            authorComment = "Немного текста по поводу статьи. Она очень интересная, замечательная, крутая! Топ, топ, топ, топ!",
            postTimestamp = 1592074546000,
            hasNewStory = true,
            postType = Posts.PostImage(urls, likes = 12)
        )
        val post2 = Post(
            id = 1,
            profileName = "sashawithoutflex",
            profileImageUrl = "https://instagram.fods2-1.fna.fbcdn.net/v/t51.2885-19/s150x150/60364515_2387773171288743_9027736078953480192_n.jpg?_nc_ht=instagram.fods2-1.fna.fbcdn.net&_nc_ohc=aIIuFbalm_UAX9nq_az&oh=05efe5b9c51d16f234e8e2c81698b743&oe=5F0BFE2F",
            postComments = 2,
            authorComment = "Author comment",
            postTimestamp = 1591827300,
            hasNewStory = false,
            postType = Posts.PostVideo(listOf("https://videocdn.bodybuilding.com/video/mp4/62000/62792m.mp4", "https://videocdn.bodybuilding.com/video/mp4/62000/62792m.mp4"), views = 12342)
        )
        val post3 = Post(
            id = 2,
            profileName = "aleksandr_sigol",
            profileImageUrl = "https://instagram.fods2-1.fna.fbcdn.net/v/t51.2885-19/s150x150/30604614_1415671615205096_633146843072561152_n.jpg?_nc_ht=instagram.fods2-1.fna.fbcdn.net&_nc_ohc=lmfc8whPLZ4AX94MQpr&oh=54733d970b67bf023e13a5a4b79f592f&oe=5F0AF454",
            postComments = 2,
            authorComment = "Author comment",
            postTimestamp = 1591827300,
            hasNewStory = false,
            postType = Posts.AdvertImage(urls, likes = 12)
        )
        val post4 = Post(
            id = 3,
            profileName = "topvenger",
            profileImageUrl = "https://instagram.fods2-1.fna.fbcdn.net/v/t51.2885-19/s150x150/83093619_617866382120238_4113447194793607168_n.jpg?_nc_ht=instagram.fods2-1.fna.fbcdn.net&_nc_ohc=qHxmz0Sn14MAX8JXFQC&oh=0cd865a775c8b3076ac1a4162737c46e&oe=5F0C4590",
            postComments = 2,
            authorComment = "Author comment",
            postTimestamp = 1591827300,
            hasNewStory = false,
            postType = Posts.AdvertVideo(listOf("https://videocdn.bodybuilding.com/video/mp4/62000/62792m.mp4", "https://videocdn.bodybuilding.com/video/mp4/62000/62792m.mp4"), views = 12345)
        )
        val post5 = Post(
            profileName = "topvenger",
            profileImageUrl = "https://instagram.fods2-1.fna.fbcdn.net/v/t51.2885-19/s150x150/83093619_617866382120238_4113447194793607168_n.jpg?_nc_ht=instagram.fods2-1.fna.fbcdn.net&_nc_ohc=qHxmz0Sn14MAX8JXFQC&oh=0cd865a775c8b3076ac1a4162737c46e&oe=5F0C4590",
            postComments = 2,
            authorComment = "Author comment",
            postTimestamp = 1591827300,
            hasNewStory = false,
            postType = Posts.PostImage(urls, likes = 12)
        )
        val post6 = Post(
            profileName = "topvenger",
            profileImageUrl = "https://instagram.fods2-1.fna.fbcdn.net/v/t51.2885-19/s150x150/83093619_617866382120238_4113447194793607168_n.jpg?_nc_ht=instagram.fods2-1.fna.fbcdn.net&_nc_ohc=qHxmz0Sn14MAX8JXFQC&oh=0cd865a775c8b3076ac1a4162737c46e&oe=5F0C4590",

            postComments = 2,
            authorComment = "Author comment",
            postTimestamp = 1591827300,
            hasNewStory = false,
            postType = Posts.PostImage(urls, likes = 12)
        )
        val post7 = Post(
            profileName = "topvenger",
            profileImageUrl = "https://instagram.fods2-1.fna.fbcdn.net/v/t51.2885-19/s150x150/83093619_617866382120238_4113447194793607168_n.jpg?_nc_ht=instagram.fods2-1.fna.fbcdn.net&_nc_ohc=qHxmz0Sn14MAX8JXFQC&oh=0cd865a775c8b3076ac1a4162737c46e&oe=5F0C4590",
            postComments = 2,
            authorComment = "Author comment",
            postTimestamp = 1591827300,
            hasNewStory = false,
            postType = Posts.PostImage(urls, likes = 12)
        )
        val post8 = Post(
            profileName = "topvenger",
            profileImageUrl = "https://instagram.fods2-1.fna.fbcdn.net/v/t51.2885-19/s150x150/83093619_617866382120238_4113447194793607168_n.jpg?_nc_ht=instagram.fods2-1.fna.fbcdn.net&_nc_ohc=qHxmz0Sn14MAX8JXFQC&oh=0cd865a775c8b3076ac1a4162737c46e&oe=5F0C4590",
            postComments = 2,
            authorComment = "Author comment",
            postTimestamp = 1591827300,
            hasNewStory = false,
            postType = Posts.PostImage(urls, likes = 12)
        )
        val post9 = Post(
            profileName = "topvenger",
            profileImageUrl = "https://instagram.fods2-1.fna.fbcdn.net/v/t51.2885-19/s150x150/83093619_617866382120238_4113447194793607168_n.jpg?_nc_ht=instagram.fods2-1.fna.fbcdn.net&_nc_ohc=qHxmz0Sn14MAX8JXFQC&oh=0cd865a775c8b3076ac1a4162737c46e&oe=5F0C4590",
            postComments = 2,
            authorComment = "Author comment",
            postTimestamp = 1591827300,
            hasNewStory = false,
            postType = Posts.PostImage(urls, likes = 12)
        )
        val post10 = Post(
            profileName = "topvenger",
            profileImageUrl = "https://instagram.fods2-1.fna.fbcdn.net/v/t51.2885-19/s150x150/83093619_617866382120238_4113447194793607168_n.jpg?_nc_ht=instagram.fods2-1.fna.fbcdn.net&_nc_ohc=qHxmz0Sn14MAX8JXFQC&oh=0cd865a775c8b3076ac1a4162737c46e&oe=5F0C4590",
            postComments = 2,
            authorComment = "Author comment",
            postTimestamp = 1591827300,
            hasNewStory = false,
            postType = Posts.PostImage(urls, likes = 12)
        )
        val post11 = Post(
            profileName = "topvenger",
            profileImageUrl = "https://instagram.fods2-1.fna.fbcdn.net/v/t51.2885-19/s150x150/83093619_617866382120238_4113447194793607168_n.jpg?_nc_ht=instagram.fods2-1.fna.fbcdn.net&_nc_ohc=qHxmz0Sn14MAX8JXFQC&oh=0cd865a775c8b3076ac1a4162737c46e&oe=5F0C4590",
            postComments = 2,
            authorComment = "Author comment",
            postTimestamp = 1591827300,
            hasNewStory = false,
            postType = Posts.PostImage(urls, likes = 12)
        )
        val post12 = Post(
            profileName = "topvenger",
            profileImageUrl = "https://instagram.fods2-1.fna.fbcdn.net/v/t51.2885-19/s150x150/83093619_617866382120238_4113447194793607168_n.jpg?_nc_ht=instagram.fods2-1.fna.fbcdn.net&_nc_ohc=qHxmz0Sn14MAX8JXFQC&oh=0cd865a775c8b3076ac1a4162737c46e&oe=5F0C4590",
            postComments = 2,
            authorComment = "Author comment",
            postTimestamp = 1591827300,
            hasNewStory = false,
            postType = Posts.PostImage(urls, likes = 12)
        )
        val post13 = Post(
            profileName = "topvenger",
            profileImageUrl = "https://instagram.fods2-1.fna.fbcdn.net/v/t51.2885-19/s150x150/83093619_617866382120238_4113447194793607168_n.jpg?_nc_ht=instagram.fods2-1.fna.fbcdn.net&_nc_ohc=qHxmz0Sn14MAX8JXFQC&oh=0cd865a775c8b3076ac1a4162737c46e&oe=5F0C4590",
            postComments = 2,
            authorComment = "Author comment",
            postTimestamp = 1591827300,
            hasNewStory = false,
            postType = Posts.PostImage(urls, likes = 12)
        )
        val post14 = Post(
            profileName = "topvenger",
            profileImageUrl = "https://instagram.fods2-1.fna.fbcdn.net/v/t51.2885-19/s150x150/83093619_617866382120238_4113447194793607168_n.jpg?_nc_ht=instagram.fods2-1.fna.fbcdn.net&_nc_ohc=qHxmz0Sn14MAX8JXFQC&oh=0cd865a775c8b3076ac1a4162737c46e&oe=5F0C4590",
            postComments = 2,
            authorComment = "Author comment",
            postTimestamp = 1591827300,
            hasNewStory = false,
            postType = Posts.PostImage(urls, likes = 12)
        )
        val post15 = Post(
            profileName = "topvenger",
            profileImageUrl = "https://instagram.fods2-1.fna.fbcdn.net/v/t51.2885-19/s150x150/83093619_617866382120238_4113447194793607168_n.jpg?_nc_ht=instagram.fods2-1.fna.fbcdn.net&_nc_ohc=qHxmz0Sn14MAX8JXFQC&oh=0cd865a775c8b3076ac1a4162737c46e&oe=5F0C4590",
            postComments = 2,
            authorComment = "Author comment",
            postTimestamp = 1591827300,
            hasNewStory = false,
            postType = Posts.PostImage(urls, likes = 12)
        )
        val post16 = Post(
            profileName = "topvenger",
            profileImageUrl = "https://instagram.fods2-1.fna.fbcdn.net/v/t51.2885-19/s150x150/83093619_617866382120238_4113447194793607168_n.jpg?_nc_ht=instagram.fods2-1.fna.fbcdn.net&_nc_ohc=qHxmz0Sn14MAX8JXFQC&oh=0cd865a775c8b3076ac1a4162737c46e&oe=5F0C4590",
            postComments = 2,
            authorComment = "Author comment",
            postTimestamp = 1591827300,
            hasNewStory = false,
            postType = Posts.PostImage(urls, likes = 12)
        )
        val post17 = Post(
            profileName = "topvenger",
            profileImageUrl = "https://instagram.fods2-1.fna.fbcdn.net/v/t51.2885-19/s150x150/83093619_617866382120238_4113447194793607168_n.jpg?_nc_ht=instagram.fods2-1.fna.fbcdn.net&_nc_ohc=qHxmz0Sn14MAX8JXFQC&oh=0cd865a775c8b3076ac1a4162737c46e&oe=5F0C4590",
            postComments = 2,
            authorComment = "Author comment",
            postTimestamp = 1591827300,
            hasNewStory = false,
            postType = Posts.PostImage(urls, likes = 12)
        )
        val post18 = Post(
            profileName = "topvenger",
            profileImageUrl = "https://instagram.fods2-1.fna.fbcdn.net/v/t51.2885-19/s150x150/83093619_617866382120238_4113447194793607168_n.jpg?_nc_ht=instagram.fods2-1.fna.fbcdn.net&_nc_ohc=qHxmz0Sn14MAX8JXFQC&oh=0cd865a775c8b3076ac1a4162737c46e&oe=5F0C4590",
            postComments = 2,
            authorComment = "Author comment",
            postTimestamp = 1591827300,
            hasNewStory = false,
            postType = Posts.PostImage(urls, likes = 12)
        )
        val post19 = Post(
            profileName = "topvenger",
            profileImageUrl = "https://instagram.fods2-1.fna.fbcdn.net/v/t51.2885-19/s150x150/83093619_617866382120238_4113447194793607168_n.jpg?_nc_ht=instagram.fods2-1.fna.fbcdn.net&_nc_ohc=qHxmz0Sn14MAX8JXFQC&oh=0cd865a775c8b3076ac1a4162737c46e&oe=5F0C4590",
            postComments = 2,
            authorComment = "Author comment",
            postTimestamp = 1591827300,
            hasNewStory = false,
            postType = Posts.PostImage(urls, likes = 12)
        )
        val post20 = Post(
            profileName = "topvenger",
            profileImageUrl = "https://instagram.fods2-1.fna.fbcdn.net/v/t51.2885-19/s150x150/83093619_617866382120238_4113447194793607168_n.jpg?_nc_ht=instagram.fods2-1.fna.fbcdn.net&_nc_ohc=qHxmz0Sn14MAX8JXFQC&oh=0cd865a775c8b3076ac1a4162737c46e&oe=5F0C4590",
            postComments = 2,
            authorComment = "Author comment",
            postTimestamp = 1591827300,
            hasNewStory = false,
            postType = Posts.PostImage(urls, likes = 12)
        )
        val post21 = Post(
            profileName = "topvenger",
            profileImageUrl = "https://instagram.fods2-1.fna.fbcdn.net/v/t51.2885-19/s150x150/83093619_617866382120238_4113447194793607168_n.jpg?_nc_ht=instagram.fods2-1.fna.fbcdn.net&_nc_ohc=qHxmz0Sn14MAX8JXFQC&oh=0cd865a775c8b3076ac1a4162737c46e&oe=5F0C4590",
            postComments = 2,
            authorComment = "Author comment",
            postTimestamp = 1591827300,
            hasNewStory = false,
            postType = Posts.PostImage(urls, likes = 12)
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
                profile_image_url = "https://instagram.fods2-1.fna.fbcdn.net/v/t51.2885-19/s320x320/37735926_1396421363835870_7107451605296873472_n.jpg?_nc_ht=instagram.fods2-1.fna.fbcdn.net&_nc_ohc=dbP1VK-VPIsAX-ALdE7&oh=84057bc1c7fff5a9b2b364e5761603c3&oe=5F0D5CA9",
                has_unchecked_story = false,
                story_type = Stories.MY_STORY
            )
            val story2 = Story(
                profile_name = "profile_name2",
                profile_image_url = "https://instagram.fods2-1.fna.fbcdn.net/v/t51.2885-19/s320x320/37735926_1396421363835870_7107451605296873472_n.jpg?_nc_ht=instagram.fods2-1.fna.fbcdn.net&_nc_ohc=dbP1VK-VPIsAX-ALdE7&oh=84057bc1c7fff5a9b2b364e5761603c3&oe=5F0D5CA9",
                has_unchecked_story = true
            )
            val story3 = Story(
                profile_name = "profile_name3",
                profile_image_url = "https://instagram.fods2-1.fna.fbcdn.net/v/t51.2885-19/s320x320/37735926_1396421363835870_7107451605296873472_n.jpg?_nc_ht=instagram.fods2-1.fna.fbcdn.net&_nc_ohc=dbP1VK-VPIsAX-ALdE7&oh=84057bc1c7fff5a9b2b364e5761603c3&oe=5F0D5CA9",
                has_unchecked_story = true
            )
            val story4 = Story(
                profile_name = "profile_name4",
                profile_image_url = "https://instagram.fods2-1.fna.fbcdn.net/v/t51.2885-19/s320x320/37735926_1396421363835870_7107451605296873472_n.jpg?_nc_ht=instagram.fods2-1.fna.fbcdn.net&_nc_ohc=dbP1VK-VPIsAX-ALdE7&oh=84057bc1c7fff5a9b2b364e5761603c3&oe=5F0D5CA9",
                has_unchecked_story = true
            )
            val story5 = Story(
                profile_name = "profile_name5",
                profile_image_url = "https://instagram.fods2-1.fna.fbcdn.net/v/t51.2885-19/s320x320/37735926_1396421363835870_7107451605296873472_n.jpg?_nc_ht=instagram.fods2-1.fna.fbcdn.net&_nc_ohc=dbP1VK-VPIsAX-ALdE7&oh=84057bc1c7fff5a9b2b364e5761603c3&oe=5F0D5CA9",
                has_unchecked_story = true
            )
            val story6 = Story(
                profile_name = "profile_name6",
                profile_image_url = "https://instagram.fods2-1.fna.fbcdn.net/v/t51.2885-19/s320x320/37735926_1396421363835870_7107451605296873472_n.jpg?_nc_ht=instagram.fods2-1.fna.fbcdn.net&_nc_ohc=dbP1VK-VPIsAX-ALdE7&oh=84057bc1c7fff5a9b2b364e5761603c3&oe=5F0D5CA9",
                has_unchecked_story = true
            )
            val story7 = Story(
                profile_name = "profile_name7",
                profile_image_url = "https://instagram.fods2-1.fna.fbcdn.net/v/t51.2885-19/s320x320/37735926_1396421363835870_7107451605296873472_n.jpg?_nc_ht=instagram.fods2-1.fna.fbcdn.net&_nc_ohc=dbP1VK-VPIsAX-ALdE7&oh=84057bc1c7fff5a9b2b364e5761603c3&oe=5F0D5CA9",
                has_unchecked_story = false
            )
            val story8 = Story(
                profile_name = "profile_name8",
                profile_image_url = "https://instagram.fods2-1.fna.fbcdn.net/v/t51.2885-19/s320x320/37735926_1396421363835870_7107451605296873472_n.jpg?_nc_ht=instagram.fods2-1.fna.fbcdn.net&_nc_ohc=dbP1VK-VPIsAX-ALdE7&oh=84057bc1c7fff5a9b2b364e5761603c3&oe=5F0D5CA9",
                has_unchecked_story = false
            )
            val story9 = Story(
                profile_name = "profile_name9",
                profile_image_url = "https://instagram.fods2-1.fna.fbcdn.net/v/t51.2885-19/s320x320/37735926_1396421363835870_7107451605296873472_n.jpg?_nc_ht=instagram.fods2-1.fna.fbcdn.net&_nc_ohc=dbP1VK-VPIsAX-ALdE7&oh=84057bc1c7fff5a9b2b364e5761603c3&oe=5F0D5CA9",
                has_unchecked_story = true
            )
            val story10 = Story(
                profile_name = "profile_name10",
                profile_image_url = "https://instagram.fods2-1.fna.fbcdn.net/v/t51.2885-19/s320x320/37735926_1396421363835870_7107451605296873472_n.jpg?_nc_ht=instagram.fods2-1.fna.fbcdn.net&_nc_ohc=dbP1VK-VPIsAX-ALdE7&oh=84057bc1c7fff5a9b2b364e5761603c3&oe=5F0D5CA9",
                has_unchecked_story = false
            )

            it.onSuccess(listOf(story1, story2, story3, story4, story5, story6, story7, story8, story9, story10))
        }
    }

    fun getProfile(): Single<Profile>{
        return Single.create {
            val profile = Profile(username = "egor_sigolaev", profile_image_url = "https://instagram.fods2-1.fna.fbcdn.net/v/t51.2885-19/s320x320/37735926_1396421363835870_7107451605296873472_n.jpg?_nc_ht=instagram.fods2-1.fna.fbcdn.net&_nc_ohc=dbP1VK-VPIsAX-ALdE7&oh=84057bc1c7fff5a9b2b364e5761603c3&oe=5F0D5CA9")
            it.onSuccess(profile)
        }
    }
}