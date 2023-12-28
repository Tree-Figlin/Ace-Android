package com.tree.design_system.component.text

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.tree.design_system.icon.AceLogoIcon
import com.tree.design_system.theme.AceTheme

@Composable
fun AceLogoTitleText() {
    AceTheme { colors, typography ->
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AceLogoIcon()
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = "ACE",
                style = typography.largeTitle,
                fontWeight = FontWeight.SemiBold,
                color = colors.PRIMARY
            )
        }
    }
}