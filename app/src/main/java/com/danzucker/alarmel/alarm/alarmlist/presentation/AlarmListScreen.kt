@file:OptIn(ExperimentalMaterial3Api::class)

package com.danzucker.alarmel.alarm.alarmlist.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.danzucker.alarmel.R
import com.danzucker.alarmel.alarm.alarmlist.presentation.components.AlarmListItem
import com.danzucker.alarmel.alarm.alarmlist.presentation.components.previewAlarm
import com.danzucker.alarmel.alarm.core.presentation.components.AlarmelFloatingActionButton
import com.danzucker.alarmel.alarm.core.presentation.components.AlarmelScaffold
import com.danzucker.alarmel.alarm.core.presentation.components.AlarmelToolbar
import com.danzucker.alarmel.ui.theme.AlarmelTheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun AlarmListScreenRoot(
    viewModel: AlarmListViewModel = koinViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    AlarmListScreen(
        state = uiState,
        onAction = {},
        modifier = Modifier
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlarmListScreen(
    state: AlarmListState,
    onAction: (AlarmListAction) -> Unit,
    modifier: Modifier = Modifier
) {

    val topAppBarState = rememberTopAppBarState()
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(
        state = topAppBarState
    )

    AlarmelScaffold(
        topAppBar = {
            AlarmelToolbar(
                title = stringResource(R.string.your_alarm),
                scrollBehavior = scrollBehavior,
                showBackButton = false,
                showForwardButton = false,
                modifier = Modifier
                    .fillMaxWidth()
            )
        },
        floatingActionButton = {
            AlarmelFloatingActionButton(
                icon = Icons.Default.Add,
                onClick = {},
                iconSize = 30.dp
            )
        },
        modifier = modifier
    ) { paddingValues ->
        if (state.alarms.isEmpty()) {
            EmptyScreen(modifier = modifier)
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .nestedScroll(scrollBehavior.nestedScrollConnection),
                contentPadding = paddingValues
            ) {
                items(
                    items = state.alarms,
                    key = { it.id }
                ) {alarmUi ->
                    AlarmListItem(
                        alarmUi = alarmUi,
                        onEnableClick = { alarmId, isEnable ->
                            onAction(
                                AlarmListAction.OnToggleClick(
                                    alarmId = alarmId,
                                    isEnable = isEnable
                                )
                            )
                        },
                        modifier = Modifier
                            .animateItem()
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun AlarmListScreenPreview() {
    AlarmelTheme {
        AlarmListScreen(
            state = AlarmListState(
                alarms = (0..100).map {
                    previewAlarm.copy(id = it.toString())
                }
            ),
            onAction = {}
        )
    }
}

