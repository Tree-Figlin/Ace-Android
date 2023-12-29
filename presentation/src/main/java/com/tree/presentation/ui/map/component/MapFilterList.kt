package com.tree.presentation.ui.map.component

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.google.android.gms.maps.model.LatLng
import com.tree.design_system.theme.AceTheme

@Composable
fun MapFilterList(
    onCheckClick: () -> Unit,
    onBackClick: () -> Unit
) {
    val list = listOf("서울", "경기", "강원", "경상", "충청", "전라")
    AceTheme { colors, typography ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(500.dp)
                .background(colors.WHITE)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp))
                    .padding(top = 16.dp, start = 16.dp, end = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                Row(
                    modifier = Modifier.clickable { onBackClick() }
                ) {
                    Text(
                        text = "필터",
                        style = typography.smallTitle,
                        fontWeight = FontWeight.SemiBold
                    )
                }
                MapFilterCheckButton { onCheckClick() }
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .background(colors.WHITE)
            ) {
                LazyRow(modifier = Modifier.fillMaxSize()) {
                    items(list.size) {index ->
                        MapFilterListButton(location = list[index]) {}
                    }
                }
            }
        }
    }
}
