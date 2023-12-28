package com.tree.data.remote.dto.news.response

import com.google.gson.annotations.SerializedName
import com.tree.domain.model.news.response.ArticleListModel
import com.tree.domain.model.news.response.NewsResponseModel
import com.tree.domain.model.news.response.SourceModel

data class NewsResponse(
    val status: String,
    val totalResults: Int,
    val articles: List<ArticleList>
)

data class ArticleList(
    val source: Source,
    val author: String?,
    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String?,
    val publishedAt: String,
    val content: String
)

data class Source(
    val id: String?,
    val name: String
)


fun NewsResponse.toNewsModel() =
    NewsResponseModel(
        status = this.status,
        totalResults = this.totalResults,
        articles = this.articles.map { it.toNewsModel() }
    )

fun ArticleList.toNewsModel() =
    ArticleListModel(
        source = this.source.toNewsModel(),
        author = this.author,
        title = this.title,
        description = this.description,
        url = this.url,
        urlToImage = this.urlToImage,
        publishedAt = this.publishedAt,
        content = this.content
    )

fun Source.toNewsModel() =
    SourceModel(
        id = this.id,
        name = this.name
    )