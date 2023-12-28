package com.tree.presentation.ui.home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.tree.design_system.component.botton.AceNextButton
import com.tree.design_system.theme.AceTheme

@Composable
fun HomeTitleText(
    title: String,
    onDetailClick: () -> Unit
) {
    AceTheme { colors, typography ->
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = title,
                style = typography.smallTitle,
                fontWeight = FontWeight.SemiBold,
                color = colors.BLACK
            )
            AceNextButton(onClick = { onDetailClick() })
        }
    }
}