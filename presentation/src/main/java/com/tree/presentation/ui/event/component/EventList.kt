package com.tree.presentation.ui.event.component

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
import com.tree.domain.model.news.response.ArticleListModel
import com.tree.presentation.ui.event.data.EventListItem
import com.tree.presentation.ui.util.toDateString
import com.tree.presentation.viewmodel.NewsViewModel

@Composable
fun EventList(
    list: List<EventListItem>,
    onItemClick: () -> Unit
) {
    AceTheme { colors, typography ->
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(list.size) { index ->
                val listItem = list[index]
                EventListItem(
                    title = listItem.title,
                    date = listItem.date,
                    imageUrl = listItem.imageUrl,
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