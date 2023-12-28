package com.tree.presentation.ui.map.component.bottomsheet

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tree.design_system.theme.AceTheme
import com.tree.presentation.ui.map.component.MapFilterButton

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MapBottomSheet(
    onFilterClick: () -> Unit
) {
    AceTheme { colors, typography ->
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp))
                    .background(colors.WHITE)
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "검색 결과",
                    style = typography.smallTitle,
                    fontWeight = FontWeight.SemiBold
                )
                MapFilterButton { onFilterClick() }
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(292.dp)
                    .background(colors.WHITE)
            ) {
                LazyColumn(modifier = Modifier.fillMaxSize()) {

                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun MapBottomSheetPreview() {
    AceTheme { colors, typography ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(colors.BLACK)
        ) {
            MapBottomSheet{}
        }
    }
}