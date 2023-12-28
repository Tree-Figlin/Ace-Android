package com.tree.presentation.ui.news.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tree.design_system.component.botton.AceBackButton
import com.tree.design_system.component.botton.SearchButton
import com.tree.design_system.component.text.AceTitleText
import com.tree.design_system.component.textfield.AceSearchTextField
import com.tree.domain.model.news.response.ArticleListModel
import com.tree.presentation.BuildConfig
import com.tree.presentation.ui.news.component.NewsList
import com.tree.presentation.viewmodel.NewsViewModel

@Composable
fun NewsScreen(
    viewModel: NewsViewModel,
    onItemClick: (listItem: ArticleListModel) -> Unit
) {
    var isSearch by remember { mutableStateOf(false) }
    var search by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 80.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            if (!isSearch) {
                AceTitleText(
                    modifier = Modifier.weight(1f),
                    text = "뉴스"
                )
                SearchButton {
                    isSearch = true
                }
            } else {
                AceBackButton {
                    isSearch = false
                }
                AceSearchTextField(
                    modifier = Modifier.fillMaxWidth(),
                    debounceTime = 300L,
                    placeHolder = "검색어를 입력해주세요",
                    setText = search,
                    onValueChange = { searchChange ->
                        search = searchChange
                    },
                    onSearchTextChange = {
                        if (it.isNotBlank()) {
                            viewModel.news(it, BuildConfig.NEWS_API_KEY)
                        }
                    },
                    singleLine = true
                )
            }
        }
        Column(modifier = Modifier.padding(horizontal = 16.dp)) {
            NewsList(
                viewModel = viewModel,
                onItemClick = { listItem ->
                    onItemClick(listItem)
                }
            )
        }
    }
}