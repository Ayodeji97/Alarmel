package com.danzucker.alarmel.alarm.alarmsettings.presentation

sealed interface AlarmSettingsAction {
    data object OnSaveClick: AlarmSettingsAction
    data object OnBackClick: AlarmSettingsAction
    data class OnHourChanged(val hour: String): AlarmSettingsAction
    data class OnMinuteChanged(val minute: String): AlarmSettingsAction
    data class OnAlarmNameClick(
        val alarmName: String
    ): AlarmSettingsAction
}