package com.egorsigolaev.alyaintstagram.app.di

import com.egorsigolaev.alyaintstagram.app.App
import com.egorsigolaev.alyaintstagram.app.presenters.MainPresenter
import com.egorsigolaev.alyaintstagram.data.datasource.PostsDataSource
import com.egorsigolaev.alyaintstagram.domain.repositories.PostsMapper
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton


@Component(modules = [AppModule::class, RepositoryModule::class, MapperModule::class])
@Singleton
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: App): Builder
        fun build(): AppComponent
    }


    fun inject(app: App)

    // Presenters
    fun inject(mainPresenter: MainPresenter)

    // DataSource
    fun inject(dataSource: PostsDataSource)

    // Mappers
    fun inject(postsMapper: PostsMapper)
}