package com.tree.presentation.ui.map.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tree.design_system.theme.AceTheme
import com.tree.presentation.R

@Composable
fun MapBackButton(
    onClick: () -> Unit
) {
    AceTheme { _, _ ->
        IconButton(
            modifier = Modifier
                .size(56.dp, 56.dp),
            onClick = { onClick() }
        ) {
            Image(
                painter = painterResource(id = com.tree.design_system.R.drawable.ic_map_back),
                contentDescription = "MapBackButton",
            )
        }
    }
}

@Composable
fun MapFilterButton(
    onClick: () -> Unit
) {
    AceTheme { colors, typography ->
        Row(
            modifier = Modifier
                .size(100.dp, 36.dp)
                .clickable {
                    onClick()
                },
            verticalAlignment = Alignment.Top,

        ) {
            Image(
                painter = painterResource(id = com.tree.design_system.R.drawable.ic_map_filter),
                contentDescription = "filter"
            )
            Text(
                text = "필터",
                style = typography.smallButton,
                fontWeight = FontWeight.Medium,
                color = colors.BULE1
            )
        }
    }
}

@Composable
fun MapLocationButton(
    onClick: () -> Unit
) {
    AceTheme { _, _ ->
        IconButton(
            modifier = Modifier
                .size(36.dp, 36.dp),
            onClick = { onClick() }
        ) {
            Image(
                painter = painterResource(id = com.tree.design_system.R.drawable.ic_map_location),
                contentDescription = "MapLocationButton",
            )
        }
    }
}

@Composable
fun MapFilterListButton(
    location: String,
    onClick: () -> Unit
) {
    var isSelected by remember { mutableStateOf(false) }
    AceTheme { colors, typography ->
        IconButton(
            modifier = Modifier
                .size(70.dp, 44.dp),
            onClick = {
                isSelected = !isSelected
                onClick()
            },
        ) {
            if(isSelected) {
                Image(
                    painter = painterResource(id = com.tree.design_system.R.drawable.ic_map_filter_fill),
                    contentDescription = "MapFilterFillButton",
                )
                Text(text = location)
            } else {
                Image(
                    painter = painterResource(id = com.tree.design_system.R.drawable.ic_map_filter_blank),
                    contentDescription = "MapFilterBlankButton",
                )
                Text(text = location)
            }
        }
    }
}

@Composable
fun MapFilterCheckButton(
    onClick: () -> Unit
) {
    AceTheme { colors, typography ->
        Row(
            modifier = Modifier
                .size(30.dp, 44.dp)
                .clickable {
                    onClick()
                },
            verticalAlignment = Alignment.Top,
            ) {
            Text(
                text = "확인",
                style = typography.smallButton,
                fontWeight = FontWeight.Medium,
                color = colors.BULE1
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun MapBackButtonPreview() {
    AceTheme { colors, typography ->
        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(colors.WHITE)
        ) {
            MapBackButton {}
            MapFilterButton {}
            MapLocationButton {}
            MapFilterListButton(location = "광주") {}
        }
    }
}