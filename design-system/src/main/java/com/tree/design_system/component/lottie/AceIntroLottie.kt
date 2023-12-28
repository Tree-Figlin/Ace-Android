package com.tree.design_system.component.lottie

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieClipSpec
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieAnimatable
import com.airbnb.lottie.compose.rememberLottieComposition
import com.tree.design_system.R

@Composable
fun AceIntroLottie() {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.ace_intro))
    val lottieAnimatable = rememberLottieAnimatable()
    val progress by animateLottieCompositionAsState(
        composition = composition,
        iterations = LottieConstants.IterateForever
    )
    LaunchedEffect(composition) {
        lottieAnimatable.animate(
            composition = composition,
            clipSpec = LottieClipSpec.Frame(),
            initialProgress = 0f
        )
    }

    Box(modifier = Modifier) {
        LottieAnimation(
            composition = composition,
            progress = { progress }
        )
    }
}