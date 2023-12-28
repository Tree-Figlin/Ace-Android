package com.tree.data.repository

import com.tree.data.remote.datasource.news.NewsDataSource
import com.tree.data.remote.dto.news.response.toNewsModel
import com.tree.domain.model.news.response.NewsResponseModel
import com.tree.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val remoteNewsDataSource: NewsDataSource
) : NewsRepository {
    override suspend fun news(query: String, apiKey: String): Flow<NewsResponseModel> {
        return remoteNewsDataSource.news(
            query = query,
            apiKey = apiKey
        ).map { it.toNewsModel() }
    }
}