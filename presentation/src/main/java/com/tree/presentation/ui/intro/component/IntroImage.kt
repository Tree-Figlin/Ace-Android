package com.tree.presentation.ui.intro.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.tree.presentation.R

@Composable
fun IntroImage(modifier: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.ic_intro),
        contentDescription = "intro page background",
        modifier = modifier.size(341.dp, 400.dp),
        contentScale = ContentScale.Crop
    )
}