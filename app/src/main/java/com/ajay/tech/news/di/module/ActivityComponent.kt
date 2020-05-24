package com.ajay.tech.news.di.module

import com.ajay.tech.news.MainActivity
import com.ajay.tech.news.MainActivityModule
import com.ajay.tech.news.di.ActivityScope
import com.ajay.tech.news.di.component.ApplicationComponent
import dagger.Component


/**
 * Created by Ajay Vyas on 23/05/20.
 * Own Project
 * ajv_007@hotmail.com
 */
@ActivityScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [MainActivityModule::class]
)
interface ActivityComponent {

    fun inject(activity: MainActivity)
}