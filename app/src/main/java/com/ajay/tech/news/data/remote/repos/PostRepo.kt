package com.ajay.tech.news.data.remote.repos

import com.ajay.tech.news.data.remote.NetworkService
import com.ajay.tech.news.data.remote.response.Post
import com.ajay.tech.news.data.remote.response.PostListResponse
import io.reactivex.Single
import javax.inject.Inject


/**
 * Created by Ajay Vyas on 24/05/20.
 * Own Project
 * ajv_007@hotmail.com
 */
class PostRepo @Inject constructor(private val networkService: NetworkService) {

    fun fetchPostListSet1(): Single<List<Post>> {
        return networkService.doHomePostListCallSet1(
        ).map {
            it.posts
        }
    }
}