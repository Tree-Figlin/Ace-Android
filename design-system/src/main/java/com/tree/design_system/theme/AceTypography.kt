package com.tree.design_system.theme

import androidx.compose.runtime.Stable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.tree.design_system.R

object AceTypography {
    private val roboto = FontFamily(
        Font(R.font.roboto_black, FontWeight.Black),
        Font(R.font.roboto_bold, FontWeight.Bold),
        Font(R.font.roboto_light, FontWeight.Light),
        Font(R.font.roboto_medium, FontWeight.Medium),
        Font(R.font.roboto_regular, FontWeight.Normal),
        Font(R.font.roboto_thin, FontWeight.Thin)
    )

    @Stable
    val largeHeadline = TextStyle(
        fontFamily = roboto,
        fontSize = 40.sp,
        lineHeight = 52.sp
    )

    @Stable
    val mediumHeadline = TextStyle(
        fontFamily = roboto,
        fontSize = 36.sp,
        lineHeight = 48.sp
    )

    @Stable
    val smallHeadline = TextStyle(
        fontFamily = roboto,
        fontSize = 32.sp,
        lineHeight = 44.sp
    )

    @Stable
    val largeTitle = TextStyle(
        fontFamily = roboto,
        fontSize = 28.sp,
        lineHeight = 40.sp
    )

    @Stable
    val mediumTitle = TextStyle(
        fontFamily = roboto,
        fontSize = 24.sp,
        lineHeight = 36.sp
    )

    @Stable
    val smallTitle = TextStyle(
        fontFamily = roboto,
        fontSize = 20.sp,
        lineHeight = 32.sp
    )

    @Stable
    val largeBody = TextStyle(
        fontFamily = roboto,
        fontSize = 18.sp,
        lineHeight = 28.sp
    )

    @Stable
    val mediumBody = TextStyle(
        fontFamily = roboto,
        fontSize = 16.sp,
        lineHeight = 24.sp
    )

    @Stable
    val smallBody = TextStyle(
        fontFamily = roboto,
        fontSize = 14.sp,
        lineHeight = 20.sp
    )


    @Stable
    val caption = TextStyle(
        fontFamily = roboto,
        fontSize = 12.sp,
        lineHeight = 16.sp
    )

    @Stable
    val largeButton = TextStyle(
        fontFamily = roboto,
        fontSize = 16.sp,
        lineHeight = 52.sp
    )

    @Stable
    val smallButton = TextStyle(
        fontFamily = roboto,
        fontSize = 16.sp,
        lineHeight = 44.sp
    )
}