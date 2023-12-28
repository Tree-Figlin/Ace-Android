package com.tree.presentation.ui.news.component

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import com.tree.design_system.theme.AceTheme

@Composable
fun NewsDetailContentText(text: String) {
    AceTheme { colors, typography ->
        Text(
            text = text,
            style = typography.mediumBody,
            fontWeight = FontWeight.Normal,
            color = colors.GREYSCALE2
        )
    }
}