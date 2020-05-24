package com.ajay.tech.news.utils

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


/**
 * Created by Ajay Vyas on 22/05/20.
 * Own Project
 * ajv_007@hotmail.com
 */
data class NetworkError(
    val status: Int = -1,

    @Expose
    @SerializedName("statusCode")
    val statusCode: String = "-1",

    @Expose
    @SerializedName("message")
    val message: String ="Something went wrong"
)