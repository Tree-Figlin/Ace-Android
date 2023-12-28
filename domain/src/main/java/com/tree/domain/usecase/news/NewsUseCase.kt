package com.tree.domain.usecase.news

import com.tree.domain.repository.NewsRepository
import javax.inject.Inject

class NewsUseCase @Inject constructor(
    private val repository: NewsRepository
) {
    suspend operator fun invoke(query: String, apiKey: String) = kotlin.runCatching {
        repository.news(query, apiKey)
    }
}