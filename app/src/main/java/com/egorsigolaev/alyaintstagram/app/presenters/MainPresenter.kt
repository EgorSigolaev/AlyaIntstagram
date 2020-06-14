package com.egorsigolaev.alyaintstagram.app.presenters

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.egorsigolaev.alyaintstagram.app.App
import com.egorsigolaev.alyaintstagram.app.views.MainView
import com.egorsigolaev.alyaintstagram.domain.repositories.MainRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@InjectViewState
class MainPresenter: MvpPresenter<MainView>() {

    @Inject lateinit var repository: MainRepository
    private val disposeBag = CompositeDisposable()

    init {
        App.appComponent.inject(this)
    }

    fun loadPosts(){
        val disposable = repository.getAllPosts()
            .delay(App.LOADING_DELAY_SEC, TimeUnit.SECONDS)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                viewState.onPostsLoaded(it)
            },{})
        disposeBag.add(disposable)

    }


    fun loadStories(){
        val disposable = repository.getAllStories()
            .delay(App.LOADING_DELAY_SEC, TimeUnit.SECONDS)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                viewState.onStoriesLoaded(it)
            },{})
        disposeBag.add(disposable)
    }


    fun loadProfileImageUrl(){
        val disposable = repository.getProfile()
            .delay(App.LOADING_DELAY_SEC, TimeUnit.SECONDS)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                viewState.onProfileLoaded(it)
            },{})
        disposeBag.add(disposable)
    }

}