package com.ajay.tech.news.data.remote

import com.ajay.tech.news.data.remote.response.PostListResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query
import javax.inject.Singleton


/**
 * Created by Ajay Vyas on 23/05/20.
 * Own Project
 * ajv_007@hotmail.com
 */
@Singleton
interface NetworkService {

    @GET("59b3f0b0100000e30b236b7e")
    fun doHomePostListCallSet1(): Single<PostListResponse>

    @GET("59ac28a9100000ce0bf9c236")
    fun doHomePostListCallSet2(): Single<PostListResponse>

    @GET("59ac293b100000d60bf9c239")
    fun doHomePostListCallSet3(): Single<PostListResponse>
}