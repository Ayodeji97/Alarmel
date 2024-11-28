package com.danzucker.alarmel.alarm.alarmsettings.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.danzucker.alarmel.R
import com.danzucker.alarmel.alarm.alarmsettings.components.EditableTimeBox
import com.danzucker.alarmel.alarm.alarmsettings.components.EditableTimeMinuteBox
import com.danzucker.alarmel.alarm.core.presentation.components.AlarmelButton
import com.danzucker.alarmel.ui.theme.AlarmelTheme
import com.danzucker.alarmel.ui.theme.backgroundLightGrey
import com.danzucker.alarmel.ui.theme.backgroundWhite
import com.danzucker.alarmel.ui.theme.lightGrey
import com.danzucker.alarmel.ui.theme.onPrimary
import com.danzucker.alarmel.ui.theme.primary
import org.koin.androidx.compose.koinViewModel


@Composable
fun AlarmelSettingsScreenRoot(
    viewModel: AlarmSettingsViewModel = koinViewModel()
) {

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    AlarmelSettingsScreen(
        uiState = viewModel.state,
        onAction = viewModel::onActionTrigger
    )

}


@Composable
fun AlarmelSettingsScreen(
    uiState: AlarmSettingsState,
    onAction: (AlarmSettingsAction) -> Unit,
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = backgroundLightGrey)
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = {
                    onAction(AlarmSettingsAction.OnBackClick)
                },
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .background(color = primary)
            ) {
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = stringResource(R.string.close),
                    tint = onPrimary
                )
            }

            AlarmelButton(
                onClick = {
                    onAction(AlarmSettingsAction.OnSaveClick)
                },
                buttonText = stringResource(R.string.save),
                enabled = uiState.canSave
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .shadow(
                    elevation = 5.dp,
                    spotColor = Color.Transparent,
                    shape = RoundedCornerShape(10.dp)
                ),
            shape = RoundedCornerShape(10.dp),
            colors = CardDefaults.cardColors(
                containerColor = backgroundWhite
            )

        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp)
                ,
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                EditableTimeBox(
                    state = uiState.hours,
                    modifier = Modifier
                        .weight(1f)
                )

                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = ":",
                    fontSize = 40.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = lightGrey
                )

                Spacer(modifier = Modifier.width(10.dp))

                EditableTimeBox(
                    state = uiState.minutes,
                    modifier = Modifier
                        .weight(1f)
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .shadow(
                    elevation = 5.dp,
                    spotColor = Color.Transparent,
                    shape = RoundedCornerShape(10.dp)
                )
                .clickable {
                    onAction(AlarmSettingsAction.OnAlarmNameClick(uiState.alarmName))
                }
            ,
            shape = RoundedCornerShape(10.dp),
            colors = CardDefaults.cardColors(
                containerColor = backgroundWhite
            )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = stringResource(R.string.alarm_name),
                    style = MaterialTheme.typography.labelMedium
                )

                Text(
                    text = uiState.alarmName,
                    style = MaterialTheme.typography.bodyMedium,
                    color = lightGrey
                )
            }
        }
    }
}


@Preview
@Composable
private fun AlarmelSettingsScreenPreview() {
    AlarmelTheme {
        AlarmelSettingsScreen(
            uiState = AlarmSettingsState(),
            onAction = {}
        )
    }
}