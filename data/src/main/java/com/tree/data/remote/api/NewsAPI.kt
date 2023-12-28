package com.tree.data.remote.api

import com.tree.data.remote.dto.news.response.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsAPI {
    @GET("everything")
    suspend fun news(
        @Query("q") query: String,
        @Query("apiKey") apiKey: String,
        @Query("page") page: Long,
        @Query("pageSize") pageSize: Int
    ): NewsResponse
}