package com.danzucker.alarmel.alarm.core.domain

import com.danzucker.alarmel.alarm.alarmlist.presentation.models.DisplayableTime

data class Alarm(
    val id: String,
    val name: String,
    val isEnable: Boolean,
    val time: String,
    val duration: String,
    val meridiem: Meridiem
)

enum class Meridiem { AM, PM }
