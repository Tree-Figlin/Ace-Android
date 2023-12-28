package com.tree.presentation.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tree.domain.model.news.response.ArticleListModel
import com.tree.domain.model.news.response.NewsResponseModel
import com.tree.domain.usecase.news.NewsUseCase
import com.tree.presentation.viewmodel.util.Event
import com.tree.presentation.viewmodel.util.errorHandling
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val newsUseCase: NewsUseCase
) : ViewModel() {
    private val _newsResponse = MutableStateFlow<Event<NewsResponseModel>>(Event.Loading)
    val newsResponse = _newsResponse.asStateFlow()

    var news = mutableStateListOf<ArticleListModel>()
        private set

    fun news(query: String, apiKey: String) = viewModelScope.launch {
        newsUseCase(query, apiKey)
            .onSuccess {
                it.catch { remoteError ->
                    _newsResponse.value = remoteError.errorHandling()
                }.collect { response ->
                    _newsResponse.value = Event.Success(data = response)
                }
            }.onFailure {
                _newsResponse.value = it.errorHandling()
            }
    }

    fun saveNews(data: List<ArticleListModel>) {
        news.clear()
        news.addAll(data)
    }
}