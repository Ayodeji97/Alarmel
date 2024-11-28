package com.danzucker.alarmel.alarm.alarmlist.presentation

import com.danzucker.alarmel.alarm.alarmlist.presentation.models.AlarmUi

data class AlarmListState(
    val alarms: List<AlarmUi> = emptyList()
)
