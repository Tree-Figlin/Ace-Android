package com.tree.data.remote.datasource.news

import com.tree.data.remote.api.NewsAPI
import com.tree.data.remote.dto.news.response.NewsResponse
import com.tree.data.util.AceApiHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class NewsDataSourceImpl @Inject constructor(
    private val api: NewsAPI
) : NewsDataSource {
    override suspend fun news(query: String, apiKey: String): Flow<NewsResponse> = flow {
        emit(
            AceApiHandler<NewsResponse>()
                .httpRequest {
                    api.news(
                        query = query,
                        apiKey = apiKey,
                        page = 1,
                        pageSize = 30
                    )
                }.sendRequest()
        )
    }.flowOn(Dispatchers.IO)
}