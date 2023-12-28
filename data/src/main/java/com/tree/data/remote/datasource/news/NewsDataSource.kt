package com.tree.data.remote.datasource.news

import com.tree.data.remote.dto.news.response.NewsResponse
import kotlinx.coroutines.flow.Flow

interface NewsDataSource {
    suspend fun news(query: String, apiKey: String): Flow<NewsResponse>
}