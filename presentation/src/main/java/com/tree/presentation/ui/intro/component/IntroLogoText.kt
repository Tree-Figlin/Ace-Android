package com.tree.presentation.ui.intro.component


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.tree.design_system.icon.AceLogoIcon
import com.tree.design_system.theme.AceTheme

@Composable
fun IntroLogoText() {
    AceTheme { colors, typography ->
        Column {
            Text(
                text = "친환경 에너지부터 환경까지,",
                style = typography.mediumTitle,
                fontWeight = FontWeight.Normal,
                color = colors.BLACK
            )
            Row {
                AceLogoIcon()
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "와 함께 알아가봐요!",
                    style = typography.mediumTitle,
                    fontWeight = FontWeight.Normal,
                    color = colors.BLACK
                )
            }
        }
    }
}