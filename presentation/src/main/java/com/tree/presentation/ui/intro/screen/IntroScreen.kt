package com.tree.presentation.ui.intro.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tree.design_system.component.lottie.AceIntroLottie
import com.tree.presentation.ui.intro.component.IntroImage
import com.tree.presentation.ui.intro.component.IntroLogoText
import com.tree.presentation.ui.intro.component.IntroText
import com.tree.presentation.ui.intro.component.NextButton
import kotlinx.coroutines.delay

@Composable
fun IntroScreen(
    onHomeClick: () -> Unit
) {
    var isFirst by remember { mutableStateOf(true) }
    LaunchedEffect("Start") {
        delay(3000L)
        isFirst = false
    }

    Column(modifier = Modifier.fillMaxSize()) {
        if (isFirst) {
            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                IntroImage(modifier = Modifier.align(Alignment.BottomEnd))
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(end = 16.dp),
                    horizontalAlignment = Alignment.End
                ) {
                    Spacer(modifier = Modifier.height(50.dp))
                    IntroText(text = "환경 관련 이벤트는 없는 걸까?")
                    Spacer(modifier = Modifier.height(20.dp))
                    IntroText(text = "아이들에게 친환경 에너지를 즐겁고 쉽게 \n" +
                            "알려줄 수 있는 곳은 없을까?")
                    Spacer(modifier = Modifier.height(20.dp))
                    IntroText(text = "우리나라에는 발전소가 얼마나 있을까?")
                }
            }
        } else {
            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                AceIntroLottie()
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp, vertical = 44.dp),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    IntroLogoText()
                    NextButton {
                        onHomeClick()
                    }
                }
            }
        }
    }
}