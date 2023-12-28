package com.tree.domain.repository

import com.tree.domain.model.news.response.NewsResponseModel
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    suspend fun news(query: String, apiKey: String): Flow<NewsResponseModel>
}