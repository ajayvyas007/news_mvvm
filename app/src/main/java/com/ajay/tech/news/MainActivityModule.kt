package com.ajay.tech.news

import androidx.lifecycle.ViewModelProviders
import com.ajay.tech.news.data.remote.repos.PostRepo
import com.ajay.tech.news.utils.NetworkHelper
import com.ajay.tech.news.utils.rx.SchedulerProvider
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable


/**
 * Created by Ajay Vyas on 23/05/20.
 * Own Project
 * ajv_007@hotmail.com
 */
@Module
class MainActivityModule(private val mainActivity: MainActivity) {

    @Provides
    fun provideMainActivityViewModel(
        schedulerProvider: SchedulerProvider,
        networkHelper: NetworkHelper,
        postRepo: PostRepo
    ): MainActivityViewModel = ViewModelProviders.of(mainActivity, ViewModelProviderFactory(MainActivityViewModel::class) {
        MainActivityViewModel(schedulerProvider, networkHelper, postRepo)
            //this lambda creates and return SplashViewModel
        }).get(MainActivityViewModel::class.java)
}