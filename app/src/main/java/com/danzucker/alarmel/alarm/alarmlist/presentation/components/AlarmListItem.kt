package com.danzucker.alarmel.alarm.alarmlist.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.danzucker.alarmel.alarm.alarmlist.presentation.models.AlarmUi
import com.danzucker.alarmel.alarm.alarmlist.presentation.models.toAlarmUi
import com.danzucker.alarmel.alarm.core.domain.Alarm
import com.danzucker.alarmel.alarm.core.domain.Meridiem
import com.danzucker.alarmel.ui.theme.AlarmelTheme
import com.danzucker.alarmel.ui.theme.backgroundWhite
import com.danzucker.alarmel.ui.theme.contentDark
import com.danzucker.alarmel.ui.theme.lightGrey

@Composable
fun AlarmListItem(
    alarmUi: AlarmUi,
    onEnableClick: (String, Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp)
            .shadow(
                elevation = 15.dp,
                spotColor = Color.Transparent,
                shape = RoundedCornerShape(10.dp)
            ),
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(
            containerColor = backgroundWhite,
            contentColor = contentDark
        )
    ) {
        Row(
            modifier = Modifier
                .padding(
                    top = 8.dp,
                    start = 16.dp,
                    end = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Text(
                text = alarmUi.name,
                style = MaterialTheme.typography.labelMedium,
                color = contentDark,
                modifier = Modifier
                    .weight(1f)
            )

            AlarmelSwitch(
                checked = alarmUi.isEnable,
                onCheckedChange = { isChecked ->
                    onEnableClick(alarmUi.id, isChecked)
                }
            )

        }

        Row(
            modifier = Modifier
                .padding(
                    start = 16.dp,
                    end = 16.dp
                ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                text = alarmUi.time.formatted,
                style = MaterialTheme.typography.titleMedium,
                fontSize = 42.sp,
                color = contentDark,
                modifier = Modifier.alignByBaseline()
            )

            Text(
                text = alarmUi.meridiem,
                style = MaterialTheme.typography.titleMedium,
                color = contentDark,
                modifier = Modifier.alignByBaseline()
            )
        }

        Text(
            text = alarmUi.duration.formatted,
            style = MaterialTheme.typography.bodyMedium,
            color = lightGrey,
            modifier = Modifier
                .padding(
                    top = 8.dp,
                    start = 16.dp,
                    end = 16.dp,
                    bottom = 16.dp
                )
        )
    }

}



@Preview
@Composable
private fun AlarmListItemPreview() {
    AlarmelTheme {
        AlarmListItem(
            alarmUi = previewAlarm,
            onEnableClick = {_, _ ->}
        )
    }
}


internal val previewAlarm = Alarm(
    id = "123",
    name = "Wake Up",
    time = "10",
    isEnable = true,
    duration = "50min",
    meridiem = Meridiem.AM
).toAlarmUi()