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

@Composable
fun HomeList(
    list: List<String>,
    onItemClick: () -> Unit
) {
    AceTheme { colors, typography ->
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(list.size) { index ->
                val listItem = list[index]
                HomeListItem(
                    title = listItem,
                    text = listItem,
                    imageUrl = "",
                    onItemClick = { onItemClick() }
                )
                Divider(
                    modifier = Modifier
                        .height(1.dp)
                        .background(colors.BLACK.copy(0.15f))
                )
            }
        }
    }
}