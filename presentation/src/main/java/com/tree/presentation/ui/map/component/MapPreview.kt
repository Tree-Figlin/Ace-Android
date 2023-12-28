package com.tree.presentation.ui.map.component

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.google.maps.android.compose.GoogleMap

@Composable
fun MapPreview() {
    GoogleMap(
        modifier = Modifier.fillMaxSize()
    ) {

    }
}

@Composable
@Preview(showBackground = true)
fun MapPreviewPreview() {
    MapPreview()
}