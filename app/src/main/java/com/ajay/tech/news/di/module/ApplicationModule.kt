package com.ajay.tech.news.di.module

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.ajay.tech.news.BuildConfig
import com.ajay.tech.news.NewsApplication
import com.ajay.tech.news.data.db.DatabaseService
import com.ajay.tech.news.data.remote.NetworkService
import com.ajay.tech.news.data.remote.Networking
import com.ajay.tech.news.data.remote.Networking.API_KEY
import com.ajay.tech.news.utils.NetworkHelper
import com.ajay.tech.news.utils.rx.RxSchedulerProvider
import com.ajay.tech.news.utils.rx.SchedulerProvider
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton


/**
 * Created by Ajay Vyas on 23/05/20.
 * Own Project
 * ajv_007@hotmail.com
 */
@Module
class ApplicationModule(private val application: NewsApplication) {

    @Provides
    @Singleton
    fun provideApplication(): Application = application

    @Provides
    @Singleton
    fun provideContext(): Context = application

    @Provides
    @Singleton
    fun provideDatabaseService(): DatabaseService =
        Room.databaseBuilder(
            application, DatabaseService::class.java,
            "bootcamp-instagram-project-db"
        ).build()

    @Provides
    @Singleton
    fun provideNetworkService(): NetworkService =
        Networking.create(
            BuildConfig.BASE_URL,
            application.cacheDir,
            10 * 1024 * 1024 // 10MB
        )

    @Singleton
    @Provides
    fun provideNetworkHelper(): NetworkHelper = NetworkHelper(application)

    @Provides
    fun provideCompositeDisposable(): CompositeDisposable = CompositeDisposable()

    @Provides
    fun provideSchedulerProvider(): SchedulerProvider = RxSchedulerProvider()
}