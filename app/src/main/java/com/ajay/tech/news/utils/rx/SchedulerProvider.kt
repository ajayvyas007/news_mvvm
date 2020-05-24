package com.ajay.tech.news.utils.rx

import io.reactivex.Scheduler
import javax.inject.Singleton


/**
 * Created by Ajay Vyas on 24/05/20.
 * Own Project
 * ajv_007@hotmail.com
 */
@Singleton
interface SchedulerProvider {

    fun computation(): Scheduler

    fun io(): Scheduler

    fun ui(): Scheduler
}