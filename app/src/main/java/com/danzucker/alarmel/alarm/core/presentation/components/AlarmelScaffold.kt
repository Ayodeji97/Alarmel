package com.danzucker.alarmel.alarm.core.presentation.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.danzucker.alarmel.ui.theme.backgroundLightGrey

@Composable
fun AlarmelScaffold(
    topAppBar: (@Composable () -> Unit) = {},
    bottomAppBar: (@Composable () -> Unit) = {},
    snackbarHost: @Composable () -> Unit = {},
    floatingActionButton: @Composable () -> Unit = {},
    modifier: Modifier = Modifier,
    content: @Composable (PaddingValues) -> Unit,
) {
    Scaffold(
        topBar = topAppBar,
        bottomBar = bottomAppBar,
        snackbarHost = snackbarHost,
        floatingActionButton = floatingActionButton,
        floatingActionButtonPosition = FabPosition.Center,
        containerColor = backgroundLightGrey,
        modifier = modifier
    ) { paddingValues ->
        content(paddingValues)
    }
}