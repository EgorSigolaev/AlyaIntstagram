package com.egorsigolaev.alyaintstagram.data.datasource

import android.util.Log
import androidx.paging.PositionalDataSource
import com.egorsigolaev.alyaintstagram.app.App
import com.egorsigolaev.alyaintstagram.app.App.Companion.TAG
import com.egorsigolaev.alyaintstagram.app.interfaces.PagingListener
import com.egorsigolaev.alyaintstagram.app.models.Post
import com.egorsigolaev.alyaintstagram.domain.repositories.MainRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import java.util.concurrent.TimeUnit
import javax.inject.Inject


class PostsDataSource(private val pagingListener: PagingListener) : PositionalDataSource<Post>() {


    @Inject lateinit var repository: MainRepository
    private val disposeBag = CompositeDisposable()

    init {
        App.appComponent.inject(this)
    }

    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<Post>) {
        Log.d(TAG, "loadInitial, requestedStartPosition = ${params.requestedStartPosition}, requestedLoadSize = ${params.requestedLoadSize}")
        val disposable = repository.getPosts(params.requestedStartPosition, params.requestedLoadSize)
            .delay(App.LOADING_DELAY_SEC, TimeUnit.SECONDS)
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                pagingListener.onPageStartLoading()
            }
            .subscribe({
                pagingListener.onPageLoaded()
                callback.onResult(it, 0)
            },{})
        disposeBag.add(disposable)
    }

    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<Post>) {
        Log.d(TAG, "loadRange, startPosition = ${params.startPosition}, loadSize = ${params.loadSize}")
        val disposable = repository.getPosts(params.startPosition, params.loadSize)
            .observeOn(AndroidSchedulers.mainThread())
            .delay(App.LOADING_DELAY_SEC, TimeUnit.SECONDS)
            .doOnSubscribe {
                pagingListener.onPageStartLoading()
            }
            .subscribe({
                pagingListener.onPageLoaded()
                callback.onResult(it)
            },{})
        disposeBag.add(disposable)
    }

}