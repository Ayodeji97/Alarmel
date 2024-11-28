@file:OptIn(ExperimentalMaterial3Api::class)

package com.danzucker.alarmel.alarm.core.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.danzucker.alarmel.R
import com.danzucker.alarmel.ui.theme.AlarmelTheme
import com.danzucker.alarmel.ui.theme.contentDark
import com.danzucker.alarmel.ui.theme.onPrimary
import com.danzucker.alarmel.ui.theme.primary


@Composable
fun AlarmelToolbar(
    title: String,
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit = {},
    onForwardClick: () -> Unit = {},
    scrollBehavior: TopAppBarScrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(),
    showBackButton: Boolean = true,
    showForwardButton: Boolean = false,
    backButtonIcon: ImageVector = Icons.Default.Close,
    forwardButtonText: String = stringResource(R.string.save)
) {

    TopAppBar(
        title = {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                color = contentDark,
                modifier = Modifier
                    .padding(start = if (showBackButton) 10.dp else 0.dp)
            )
        },
        modifier = modifier,
        scrollBehavior = scrollBehavior,
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Transparent
        ),
        navigationIcon = {
            if (showBackButton) {
                AlarmelIconButton(
                    onBackClick = onBackClick,
                    imageVector = backButtonIcon,
                    modifier = Modifier.padding(start = 16.dp)
                )
            }
        },
        actions = {
            if (showForwardButton) {
                AlarmelButton(
                    onClick = onForwardClick,
                    buttonText = forwardButtonText,
                    modifier = Modifier.padding(end = 16.dp)
                )
            }
        }
    )

}

@Composable
private fun AlarmelIconButton(
    modifier: Modifier,
    onBackClick: () -> Unit,
    imageVector: ImageVector
) {
    IconButton(
        onClick = onBackClick,
        modifier = modifier
            .clip(RoundedCornerShape(10.dp))
            .background(color = primary)
    ) {
        Icon(
            imageVector = imageVector,
            contentDescription = stringResource(R.string.back),
            tint = onPrimary
        )
    }
}


@Preview
@Composable
private fun AlarmelToolbarPreview() {
    AlarmelTheme {
        AlarmelToolbar(
            title = "Your Alarms",
            modifier = Modifier.background(onPrimary),
            showForwardButton = false,
            showBackButton = false
        )
    }
}