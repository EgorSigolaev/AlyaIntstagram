package com.egorsigolaev.alyaintstagram.app.di

import com.egorsigolaev.alyaintstagram.domain.repositories.MainRepository
import com.egorsigolaev.alyaintstagram.domain.repositories.PostsMapper
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    fun provideMainRepository(mapper: PostsMapper): MainRepository{
        return MainRepository(mapper)
    }

}