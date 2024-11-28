package com.danzucker.alarmel.alarm.alarmlist.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.danzucker.alarmel.ui.theme.AlarmelTheme
import com.danzucker.alarmel.ui.theme.onPrimary
import com.danzucker.alarmel.ui.theme.onSecondary
import com.danzucker.alarmel.ui.theme.primary
import com.danzucker.alarmel.ui.theme.secondary

@Composable
fun AlarmelSwitch(
    checked: Boolean,
    onCheckedChange: ((Boolean) -> Unit),
    modifier: Modifier = Modifier
) {
    Switch(
        modifier = modifier,
        checked = checked,
        onCheckedChange = onCheckedChange,
        colors = SwitchDefaults.colors(
            checkedThumbColor = onPrimary,
            checkedTrackColor = primary,
            uncheckedThumbColor = onSecondary,
            uncheckedTrackColor = secondary,
            uncheckedBorderColor = Color.Transparent
        ),
        thumbContent = {
            Box(
                modifier = Modifier
                    .size(SwitchDefaults.IconSize)
                    .clip(CircleShape)
                    .background(onPrimary)
            )
        }
    )
}



@Preview
@Composable
private fun AlarmelSwitchPreview() {
    AlarmelTheme {
        AlarmelSwitch(
            checked = false,
            onCheckedChange = {}
        )
    }
}