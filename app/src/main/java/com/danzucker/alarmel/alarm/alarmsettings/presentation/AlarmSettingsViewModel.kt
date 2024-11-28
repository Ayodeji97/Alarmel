package com.danzucker.alarmel.alarm.alarmsettings.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.danzucker.alarmel.alarm.alarmsettings.domain.UserDataValidator
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.update

class AlarmSettingsViewModel(
    private val userDataValidator: UserDataValidator
): ViewModel() {

    private val _uiState = MutableStateFlow(AlarmSettingsState())
    val uiState: StateFlow<AlarmSettingsState> = _uiState.asStateFlow()

    var state by mutableStateOf(AlarmSettingsState())
        private set

    private val hourFlow = snapshotFlow {
        state.hours
    }

    private val minuteFlow = snapshotFlow {
        state.minutes
    }

    init {
        combine(hourFlow, minuteFlow) { hour, minutes ->
            val validationState =  userDataValidator.validateAlarmTime(
                hour = hour.text.toString(),
                minute = minutes.text.toString()
            )
            _uiState.update { currentState ->
                currentState.copy(
                    canSave = validationState.isHourValid && validationState.isMinuteValid
                )
            }
        }.launchIn(viewModelScope)
    }


    fun onActionTrigger(onAction: AlarmSettingsAction) {
        when (onAction) {
            is AlarmSettingsAction.OnAlarmNameClick -> {}
            is AlarmSettingsAction.OnBackClick -> {}
            is AlarmSettingsAction.OnSaveClick -> {}
            is AlarmSettingsAction.OnHourChanged -> {}
            is AlarmSettingsAction.OnMinuteChanged -> {}
        }
    }




// You can later remove this if not needed
//    private fun onHourChanged(hour: String) {
//        _uiState.update { currentState ->
//            val isValidHour = userDataValidator.isHourValid(hour = hour)
//            val validationState = userDataValidator.validateAlarmTime(
//                hour = hour,
//                minute = currentState.minutes.text.toString()
//            )
//
//            currentState.copy(
//                validationState = validationState,
//                canSave = isValidHour && validationState.isMinuteValid
//            )
//
//        }
//    }

//    private fun onMinuteChange(minute: String) {
//        _uiState.update { currentState ->
//            val isValidMinute = userDataValidator.isMinuteValid(minute = minute)
//            val validationState = userDataValidator.validateAlarmTime(
//                hour = currentState.hours.text.toString(),
//                minute = minute
//            )
//
//            currentState.copy(
//                validationState = validationState,
//                canSave = isValidMinute && validationState.isHourValid
//            )
//        }
//    }
}