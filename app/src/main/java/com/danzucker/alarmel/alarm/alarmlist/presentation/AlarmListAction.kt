package com.danzucker.alarmel.alarm.alarmlist.presentation

sealed interface AlarmListAction {
    data object OnAddAlarmClick: AlarmListAction
    data class OnToggleClick(
        val alarmId: String,
        val isEnable: Boolean = false
    ): AlarmListAction
    data class OnAlarmClick(
        val alarmId: String
    ): AlarmListAction
}