package com.egorsigolaev.alyaintstagram.app.di

import android.content.Context
import com.egorsigolaev.alyaintstagram.app.App
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    fun provideContext(application: App): Context {
        return application.applicationContext
    }

}