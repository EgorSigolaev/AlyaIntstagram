package com.egorsigolaev.alyaintstagram.app.di

import com.egorsigolaev.alyaintstagram.app.presenters.MainPresenter
import com.egorsigolaev.alyaintstagram.data.datasource.PostsDataSource
import dagger.Component
import javax.inject.Singleton

@Component(modules = [RepositoryModule::class])
@Singleton
interface AppComponent {

    // Presenters
    fun inject(mainPresenter: MainPresenter)

    // DataSource
    fun inject(dataSource: PostsDataSource)
}