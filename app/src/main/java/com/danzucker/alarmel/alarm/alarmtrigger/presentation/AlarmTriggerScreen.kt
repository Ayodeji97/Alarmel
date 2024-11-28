package com.danzucker.alarmel.alarm.alarmtrigger.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.danzucker.alarmel.R
import com.danzucker.alarmel.alarm.core.presentation.components.AlarmelButton
import com.danzucker.alarmel.ui.theme.AlarmelTheme
import com.danzucker.alarmel.ui.theme.contentDark
import com.danzucker.alarmel.ui.theme.primary

@Composable
fun AlarmTriggerScreen(
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.alarmel_logo_primary),
            contentDescription = stringResource(R.string.app_name),
            tint = primary
        )

        Text(
            text = "10:00",
            style = MaterialTheme.typography.titleMedium.copy(
                color = primary,
                fontSize = 82.sp,
                lineHeight = 100.sp
            )
        )

        Text(
            text = "Work",
            style = MaterialTheme.typography.labelMedium.copy(
                color = contentDark,
                fontSize = 24.sp,
                lineHeight = 30.sp
            )
        )

        Spacer(modifier = Modifier.height(24.dp))

       AlarmelButton(
           onClick = {},
           buttonText = stringResource(R.string.turn_off),
           modifier = Modifier
               .fillMaxWidth()
               .padding(start = 44.dp, end = 44.dp)
       )
    }
}


@Preview
@Composable
private fun AlarmTriggerScreenPreview() {
    AlarmelTheme {
        AlarmTriggerScreen()
    }
}