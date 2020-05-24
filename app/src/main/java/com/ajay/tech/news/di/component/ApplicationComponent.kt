package com.ajay.tech.news.di.component

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.ajay.tech.news.NewsApplication
import com.ajay.tech.news.data.db.DatabaseService
import com.ajay.tech.news.data.remote.NetworkService
import com.ajay.tech.news.di.module.ApplicationModule
import com.ajay.tech.news.utils.NetworkHelper
import com.ajay.tech.news.utils.rx.SchedulerProvider
import dagger.Component
import io.reactivex.disposables.CompositeDisposable
import java.io.File
import javax.inject.Singleton


/**
 * Created by Ajay Vyas on 23/05/20.
 * Own Project
 * ajv_007@hotmail.com
 */
@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(app: NewsApplication)

    fun getApplication(): Application

    fun getContext(): Context

    fun getNetworkService(): NetworkService

    fun getDatabaseService(): DatabaseService

    fun getNetworkHelper(): NetworkHelper

    fun getSchedulerProvider(): SchedulerProvider
}