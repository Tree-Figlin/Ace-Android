package com.tree.domain.model.news.response

data class NewsResponseModel(
    val status: String,
    val totalResults: Int,
    val articles: List<ArticleListModel>
)

data class ArticleListModel(
    val source: SourceModel,
    val author: String?,
    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String?,
    val publishedAt: String,
    val content: String
)

data class SourceModel(
    val id: String?,
    val name: String
)