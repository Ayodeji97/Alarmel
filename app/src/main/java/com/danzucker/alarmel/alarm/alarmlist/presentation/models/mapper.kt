package com.danzucker.alarmel.alarm.alarmlist.presentation.models

import com.danzucker.alarmel.alarm.core.domain.Alarm

fun Alarm.toAlarmUi(): AlarmUi {
    return AlarmUi(
        id = id,
        name = name,
        isEnable = isEnable,
        time = time.toDisplayableTime(), // work on this
        duration = duration.toDisplayableTime(), //work on this
        meridiem = meridiem.name
    )
}

// You can change the type if needed, just for now
fun String.toDisplayableTime(): DisplayableTime {
    // work on the format properly
    val formatted = "${this}:00"

    return DisplayableTime(
        time = this,
        formatted = formatted
    )
}