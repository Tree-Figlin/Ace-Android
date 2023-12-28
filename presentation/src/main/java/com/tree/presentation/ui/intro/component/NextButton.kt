package com.tree.presentation.ui.intro.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.tree.design_system.theme.AceTheme

@Composable
fun NextButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    AceTheme { colors, typography ->
        Row(modifier = modifier) {
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(colors.PRIMARY),
                onClick = { onClick() }
            ) {
                Text(
                    text = "시작하기",
                    color = colors.WHITE,
                    style = typography.largeButton,
                    fontWeight = FontWeight.Normal
                )
            }
        }
    }
}