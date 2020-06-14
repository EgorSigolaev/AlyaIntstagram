package com.egorsigolaev.alyaintstagram.app.di

import com.egorsigolaev.alyaintstagram.domain.repositories.MainRepository
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    fun provideMainRepository(): MainRepository{
        return MainRepository()
    }

}