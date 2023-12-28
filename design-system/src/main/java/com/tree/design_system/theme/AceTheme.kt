package com.tree.design_system.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import com.tree.design_system.theme.color.LightColor
import com.tree.design_system.util.ApplySystemUi

@Composable
fun AceTheme(
    colors: ColorTheme = if (!isSystemInDarkTheme()) LightColor else LightColor,
    typography: AceTypography = AceTypography,
    content: @Composable (colors: ColorTheme, typography: AceTypography) -> Unit
) {
    content(colors, typography)
    ApplySystemUi(isSystemInDarkTheme())
}