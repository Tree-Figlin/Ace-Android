package com.tree.presentation.ui.map.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tree.design_system.theme.AceTheme

@Composable
fun MapResultItem(
    title: String,
    content: String,
    onLocationClick: () -> Unit
) {
    AceTheme { colors, typography ->
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(72.dp)
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = title,
                    style = typography.mediumBody,
                    fontWeight = FontWeight.Medium
                )
                Text(
                    text = content,
                    style = typography.caption,
                    fontWeight = FontWeight.Medium
                )
            }
            MapLocationButton { onLocationClick() }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun MapResultItemPreview() {
    AceTheme { colors, typography ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(colors.WHITE)
        ) {
            MapResultItem(
                title = "서울 에너지 드림 센터",
                content = "서울특별시 마포구 증산로 14",
                onLocationClick = {}
            )
        }
    }
}