package com.danzucker.alarmel.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.danzucker.alarmel.R

val montserrat = FontFamily(
    Font(
        resId = R.font.montserrat_thin,
        weight = FontWeight.Thin
    ),
    Font(
        resId = R.font.montserrat_light,
        weight = FontWeight.Light
    ),
    Font(
        resId = R.font.montserrat_regular,
        weight = FontWeight.Normal
    ),
    Font(
        resId = R.font.montserrat_medium,
        weight = FontWeight.Medium
    ),
    Font(
        resId = R.font.montserrat_bold,
        weight = FontWeight.Bold
    ),
    Font(
        resId = R.font.montserrat_black,
        weight = FontWeight.Black
    ),
    Font(
        resId = R.font.montserrat_italic,
        weight = FontWeight.Normal,
        style = FontStyle.Italic
    ),
    Font(
        resId = R.font.montserrat_medium_italic,
        weight = FontWeight.Medium,
        style = FontStyle.Italic
    ),
    Font(
        resId = R.font.montserrat_bold_italic,
        weight = FontWeight.Bold,
        style = FontStyle.Italic
    )
)
// Set of Material typography styles to start with
val Typography = Typography(
    bodySmall = TextStyle(
        fontFamily = montserrat,
        fontWeight = FontWeight.Light,
        fontSize = 12.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = montserrat,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 17.sp,
    ),
    bodyLarge = TextStyle(
        fontFamily = montserrat,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    titleMedium = TextStyle(
        fontFamily = montserrat,
        fontWeight = FontWeight.Medium,
        fontSize = 24.sp,
        lineHeight = 30.sp
    ),
    titleLarge = TextStyle(
        fontFamily = montserrat,
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.5.sp
    ),
    labelSmall = TextStyle(
        fontFamily = montserrat,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    ),
    labelMedium = TextStyle(
        fontFamily = montserrat,
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp,
        lineHeight = 20.sp
    ),
    headlineMedium = TextStyle(
        fontFamily = montserrat,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp
    )
)