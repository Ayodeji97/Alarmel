package com.danzucker.alarmel.alarm.alarmlist.presentation.models

data class AlarmUi(
    val id: String,
    val name: String,
    val isEnable: Boolean,
    val time: DisplayableTime,
    val duration: DisplayableTime,
    val meridiem: String
)

data class DisplayableTime(
    val time: String,
    val formatted: String
)


