package com.tree.presentation.ui.news.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tree.design_system.component.text.AceTitleText
import com.tree.presentation.ui.news.component.NewsList

@Composable
fun NewsScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 80.dp)
    ) {
        AceTitleText(text = "뉴스")
        Column(modifier = Modifier.padding(horizontal = 16.dp)) {
            NewsList(
                list = listOf("첫번째", "두번째", "세번째", "네번째"),
                onItemClick = {}
            )
        }
    }
}