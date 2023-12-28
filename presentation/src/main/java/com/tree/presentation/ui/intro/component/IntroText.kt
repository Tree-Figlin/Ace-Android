package com.tree.presentation.ui.intro.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.tree.design_system.theme.AceTheme

@Composable
fun IntroText(text: String) {
    AceTheme { colors, typography ->
        Box(
            modifier = Modifier
                .background(
                    color = colors.GREYSCALE4.copy(0.5f),
                    shape = RoundedCornerShape(12.dp)
                )
                .padding(20.dp)
        ) {
            Text(
                text = text,
                style = typography.mediumBody,
                fontWeight = FontWeight.Normal,
                color = colors.BLACK
            )
        }
    }
}