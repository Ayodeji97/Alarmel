package com.danzucker.alarmel.alarm.alarmsettings.presentation

import androidx.compose.foundation.text.input.TextFieldState
import com.danzucker.alarmel.alarm.alarmlist.presentation.models.AlarmUi
import com.danzucker.alarmel.alarm.alarmsettings.domain.AlarmTimeValidationState

data class AlarmSettingsState (
    val alarmUi: AlarmUi? = null,
    val hours: TextFieldState = TextFieldState(),
    val minutes: TextFieldState = TextFieldState(),
    val validationState: AlarmTimeValidationState = AlarmTimeValidationState(),
    val nextAlarmTriggerTime: String = "",
    val alarmName: String = "",
    val canSave: Boolean = false,
)