package com.egorsigolaev.alyaintstagram.app

import android.app.Application
import com.egorsigolaev.alyaintstagram.app.di.AppComponent
import com.egorsigolaev.alyaintstagram.app.di.DaggerAppComponent
import com.egorsigolaev.alyaintstagram.app.di.RepositoryModule

class App: Application() {
    companion object{
        const val TAG = "LOG_DEBUG"
        const val LOADING_DELAY_SEC = 2L
        const val INIT_PAGE_SIZE = 10
        const val PAGE_SIZE = 10

        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        initDagger()
    }


    private fun initDagger(){
        appComponent = DaggerAppComponent.builder()
            .application(this)
            .build()
    }
}