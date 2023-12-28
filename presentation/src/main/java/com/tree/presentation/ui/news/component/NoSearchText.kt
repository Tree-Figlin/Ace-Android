package com.tree.presentation.ui.news.component

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.tree.design_system.theme.AceTheme

@Composable
fun NoSearchText() {
    AceTheme { colors, typography ->
        Text(
            text = "뉴스를 찾을 수 없어요\n" +
                    "오타나 띄어쓰기를 확인해주세요",
            style = typography.smallBody,
            fontWeight = FontWeight.Normal,
            color = colors.GREYSCALE4,
            textAlign = TextAlign.Center
        )
    }
}