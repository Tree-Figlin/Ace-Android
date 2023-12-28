package com.tree.presentation.ui.news.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tree.design_system.icon.NoSearchIcon
import com.tree.design_system.theme.AceTheme
import com.tree.presentation.ui.util.toDateString
import com.tree.presentation.viewmodel.NewsViewModel

@Composable
fun NewsList(
    viewModel: NewsViewModel,
    onItemClick: () -> Unit
) {
    AceTheme { colors, typography ->
        if (viewModel.news.size != 0) {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(viewModel.news.size) { index ->
                    val listItem = viewModel.news[index]
                    NewsListItem(
                        title = listItem.title,
                        date = listItem.publishedAt.toDateString(),
                        author = listItem.author ?: "",
                        imageUrl = listItem.urlToImage ?: "",
                        onItemClick = { onItemClick() }
                    )
                    Divider(
                        modifier = Modifier
                            .height(1.dp)
                            .background(colors.BLACK.copy(0.1f))
                    )
                }

            }
        } else {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                NoSearchIcon()
                Spacer(modifier = Modifier.height(20.dp))
                NoSearchText()
            }
        }
    }
}