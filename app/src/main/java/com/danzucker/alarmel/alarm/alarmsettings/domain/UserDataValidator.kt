package com.danzucker.alarmel.alarm.alarmsettings.domain

import androidx.core.text.isDigitsOnly

class UserDataValidator {

    fun isHourValid(hour: String): Boolean {
        return hour.isDigitsOnly() && hour.toInt() < 24
    }

    fun isMinuteValid(minute: String): Boolean {
        return minute.isDigitsOnly() && minute.toInt() < 60
    }

    fun validateAlarmTime(hour: String, minute: String): AlarmTimeValidationState{
        return AlarmTimeValidationState(
            isHourValid = isHourValid(hour = hour),
            isMinuteValid = isMinuteValid(minute = minute)
        )
    }
}

data class AlarmTimeValidationState(
    val isHourValid: Boolean = false,
    val isMinuteValid: Boolean = false
)