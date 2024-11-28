package com.danzucker.alarmel.alarm.alarmlist.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class AlarmListViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(AlarmListState())
    val uiState: StateFlow<AlarmListState> = _uiState.asStateFlow()


    fun onActionTrigger(onAction: AlarmListAction) {
        when (onAction) {
            is AlarmListAction.OnAddAlarmClick -> {}
            is AlarmListAction.OnAlarmClick -> {}
            is AlarmListAction.OnToggleClick -> {
                onAlarmToggleClicked(
                    alarmId = onAction.alarmId,
                    isEnabled = onAction.isEnable
                )
            }
        }
    }

    private fun onAlarmToggleClicked(
        alarmId: String,
        isEnabled: Boolean
    ) {
        _uiState.update { state ->
            val updatedAlarms = state.alarms.map { alarmUi ->
                if (alarmUi.id == alarmId) {
                    alarmUi.copy(isEnable = isEnabled)
                } else alarmUi
            }
            state.copy(alarms = updatedAlarms)
        }
    }
}