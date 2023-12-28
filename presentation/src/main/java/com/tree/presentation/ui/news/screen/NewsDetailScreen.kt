package com.tree.presentation.ui.news.screen

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tree.design_system.component.botton.AceBackButton
import com.tree.design_system.component.text.AceSubTitleText
import com.tree.design_system.component.text.AceTitleText
import com.tree.design_system.icon.LinkIcon
import com.tree.domain.model.news.response.ArticleListModel
import com.tree.presentation.ui.news.component.NewsDetailContentText
import com.tree.presentation.ui.news.component.NewsDetailImage
import com.tree.presentation.ui.util.copyToClipboard

@Composable
fun NewsDetailScreen(
    context: Context,
    news: ArticleListModel,
    onBackClick: () -> Unit
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(bottom = 80.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            AceBackButton {
                onBackClick()
            }
            AceSubTitleText(
                modifier = Modifier.weight(1f),
                text = "뉴스 상세보기"
            )
            IconButton(onClick = {
                val textToCopy = news.url
                copyToClipboard(context, textToCopy)
            }) {
                LinkIcon()
            }
        }
        Spacer(modifier = Modifier.height(14.dp))
        NewsDetailImage(imageUrl = news.urlToImage ?: "")
        Spacer(modifier = Modifier.height(14.dp))
        Column(modifier = Modifier.padding(horizontal = 16.dp)) {
            AceTitleText(
                modifier = Modifier.weight(1f),
                text = news.title
            )
            Spacer(modifier = Modifier.height(14.dp))
            NewsDetailContentText(text = news.description)
        }
    }
}