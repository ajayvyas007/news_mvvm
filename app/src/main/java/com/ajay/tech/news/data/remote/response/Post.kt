package com.ajay.tech.news.data.remote.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*


/**
 * Created by Ajay Vyas on 23/05/20.
 * Own Project
 * ajv_007@hotmail.com
 */
data class Post(
    @Expose
    @SerializedName("id")
    val id: String,

    @Expose
    @SerializedName("thumbnail_image")
    val imageUrl: String,

    @Expose
    @SerializedName("event_name")
    val event_name: String,

    @Expose
    @SerializedName("event_date")
    val event_date: String,

    @Expose
    @SerializedName("views")
    val views: Int?,

    @Expose
    @SerializedName("likes")
    val likes: Int?,

    @Expose
    @SerializedName("shares")
    val shares: Int?
)
