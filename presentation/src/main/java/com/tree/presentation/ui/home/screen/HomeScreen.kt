package com.tree.presentation.ui.home.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.tree.design_system.component.text.AceLogoTitleText
import com.tree.design_system.theme.AceTheme
import com.tree.presentation.BuildConfig
import com.tree.presentation.ui.home.component.HomeTitleText
import com.tree.presentation.ui.home.component.HomeList
import com.tree.presentation.viewmodel.NewsViewModel

@Composable
fun HomeScreen(
    newsViewModel: NewsViewModel,
    onNewsClick: () -> Unit,
    onEventClick: () -> Unit,
    onMapClick: () -> Unit
) {
    val scrollState = rememberScrollState()

    newsViewModel.news(query = "Environment", apiKey = BuildConfig.NEWS_API_KEY)

    AceTheme { colors, typography ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .padding(bottom = 80.dp)
        ) {
            AceLogoTitleText()
            Spacer(modifier = Modifier.height(8.dp))
            Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(shape = RoundedCornerShape(12.dp))
                        .background(colors.WHITE)
                        .padding(16.dp)
                ) {
                    HomeTitleText(
                        title = "신재생 에너지 시설 찾아보기",
                        onDetailClick = { onMapClick() }
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(shape = RoundedCornerShape(12.dp))
                        .background(colors.WHITE)
                        .padding(16.dp)
                ) {
                    Column {
                        HomeTitleText(
                            title = "\uD83D\uDCF0 오늘의 환경 뉴스",
                            onDetailClick = { onNewsClick() }
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Box(modifier = Modifier.height(264.dp)) {
                            HomeList(
                                isNews = true,
                                newsViewModel = newsViewModel,
                                onItemClick = {}
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(shape = RoundedCornerShape(12.dp))
                        .background(colors.WHITE)
                        .padding(16.dp)
                ) {
                    Column {
                        HomeTitleText(
                            title = "\uD83C\uDF89 곧 열리는 환경 이벤트",
                            onDetailClick = { onEventClick() }
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Box(modifier = Modifier.height(264.dp)) {
                            HomeList(
                                isNews = false,
                                newsViewModel = newsViewModel,
                                onItemClick = {}
                            )
                        }
                    }
                }
            }
        }
    }
}