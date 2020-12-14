package com.file.saurabh.byline.network

import com.file.saurabh.byline.network.moshipropertyclasses.TopHeadlinesProperty
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query


private val baseURL : String = "https://newsapi.org/v2/"

private val moshi : Moshi by lazy {
    Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()
}

private val retrofit : Retrofit by lazy {
    Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .baseUrl(baseURL)
        .build()
}

object NewsAPI {
    val newsServiceObject : NewsService by lazy {
        retrofit.create(NewsService::class.java)
    }
}

interface NewsService {
    @GET("everything?q=soccer-football&lang=en")
    @Headers("X-Api-Key:76f50a8f135043bc900521eb13b832cc")
    fun getTopHeadlines(@Query("from") fromDate : String ) : Deferred<TopHeadlinesProperty>

}
