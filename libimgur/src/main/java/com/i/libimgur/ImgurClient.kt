package com.i.libimgur

import com.i.libimgur.apis.ImgurAPIv3
import com.i.libimgur.converters.EnumConverterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object ImgurClient {

    private const val API_KEY = "YOUR-API-KEY"
    //TODO: ADD YOUR API KEY HERE FOR IT TO WORK
    //TODO: should be in app not in library

    private val httpClient: OkHttpClient by lazy {
        OkHttpClient.Builder()
            .addInterceptor {
                val request = it.request().newBuilder().addHeader("Authorization","Client-ID $API_KEY").build()
                it.proceed(request)
            }
            .build()
    }

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .client(httpClient)
            .addConverterFactory(MoshiConverterFactory.create())
            .addConverterFactory(EnumConverterFactory())
            .baseUrl("https://api.imgur.com/3/")
            .build()
    }
    val api :ImgurAPIv3 by lazy {
        retrofit.create(ImgurAPIv3::class.java)
    }
}