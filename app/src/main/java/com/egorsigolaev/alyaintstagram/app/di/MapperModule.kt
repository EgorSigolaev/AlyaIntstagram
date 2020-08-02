package com.egorsigolaev.alyaintstagram.app.di

import com.egorsigolaev.alyaintstagram.app.models.Post
import com.egorsigolaev.alyaintstagram.domain.repositories.PostsMapper
import dagger.Module
import dagger.Provides

@Module
class MapperModule {

    @Provides
    fun providePostsMapper(): PostsMapper{
        return PostsMapper()
    }

}