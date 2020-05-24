package com.ajay.tech.news.data.remote

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit


/**
 * Created by Ajay Vyas on 23/05/20.
 * Own Project
 * ajv_007@hotmail.com
 */
object Networking {

    const val HEADER_API_KEY = "x-api-key"
    const val HEADER_ACCESS_TOKEN = "x-access-token"
    const val HEADER_USER_ID = "x-user-id"

    private const val NETWORK_CALL_TIMEOUT = 60
    internal lateinit var API_KEY: String

    fun create(baseUrl: String, cacheDir: File, cacheSize: Long): NetworkService {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(
                OkHttpClient.Builder()
                    .cache(Cache(cacheDir, cacheSize))
                    .addInterceptor(
                        HttpLoggingInterceptor()
                        .apply {
                            level = HttpLoggingInterceptor.Level.BODY
                        })
                    .readTimeout(NETWORK_CALL_TIMEOUT.toLong(), TimeUnit.SECONDS)
                    .writeTimeout(NETWORK_CALL_TIMEOUT.toLong(), TimeUnit.SECONDS)
                    .build()
            )
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(NetworkService::class.java)
    }
}