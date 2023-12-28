package com.tree.presentation.ui.news.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun NewsDetailImage(imageUrl: String) {
    AsyncImage(
        model = imageUrl,
        modifier = Modifier
            .fillMaxWidth()
            .height(270.dp),
        contentScale = ContentScale.Crop,
        contentDescription = null,
    )
}