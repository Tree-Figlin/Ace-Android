package com.tree.presentation.ui.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tree.design_system.theme.AceTheme
import com.tree.presentation.ui.util.toDateString
import com.tree.presentation.viewmodel.NewsViewModel

@Composable
fun HomeList(
    isNews: Boolean,
    newsViewModel: NewsViewModel,
    onItemClick: () -> Unit
) {
    AceTheme { colors, typography ->
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            if (isNews) {
                items(newsViewModel.news.size) { index ->
                    val listItem = newsViewModel.news[index]
                    HomeListItem(
                        title = listItem.title,
                        text = "${listItem.publishedAt.toDateString()} | ${listItem.author}",
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
        }
    }
}