package com.danzucker.alarmel.alarm.core.presentation.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.danzucker.alarmel.ui.theme.AlarmelTheme
import com.danzucker.alarmel.ui.theme.contentDark
import com.danzucker.alarmel.ui.theme.montserrat
import com.danzucker.alarmel.ui.theme.onBackgroundSecondary
import com.danzucker.alarmel.ui.theme.onPrimary
import com.danzucker.alarmel.ui.theme.primary

@Composable
fun AlarmelButton(
    onClick: () -> Unit,
    buttonText: String,
    fontSize: TextUnit = 16.sp,
    lineHeight: TextUnit = 16.sp,
    enabled: Boolean = false,
    modifier: Modifier = Modifier
) {
    Button(
        modifier = modifier,
        onClick = onClick,
        enabled = enabled,
        shape = RoundedCornerShape(30.dp),
        colors = ButtonColors(
            containerColor = primary,
            contentColor = onPrimary,
            disabledContentColor = contentDark,
            disabledContainerColor = onBackgroundSecondary
        )
    ) {
        Text(
            text = buttonText,
            fontWeight = FontWeight.SemiBold,
            fontFamily = montserrat,
            fontSize = fontSize,
            lineHeight = lineHeight // Try to see why using fontstyle instead shows a compile time errror
        )
    }
}

@Preview
@Composable
private fun AlarmelButtonPreview() {
    AlarmelTheme {
        AlarmelButton(
            onClick = {},
            enabled = false,
            buttonText = "Turn Off"
        )
    }
}