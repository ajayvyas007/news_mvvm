package com.ajay.tech.news.data.remote.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


/**
 * Created by Ajay Vyas on 23/05/20.
 * Own Project
 * ajv_007@hotmail.com
 */
data class PostListResponse(
    @Expose
    @SerializedName("page")
    var page: String,

    @Expose
    @SerializedName("posts")
    val posts: List<Post>
)