package com.danzucker.alarmel.alarm.core.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cloud
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.danzucker.alarmel.ui.theme.AlarmelTheme
import com.danzucker.alarmel.ui.theme.onPrimary
import com.danzucker.alarmel.ui.theme.primary

@Composable
fun AlarmelFloatingActionButton(
    icon: ImageVector,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    contentDescription: String? = null,
    iconSize: Dp = 25.dp
) {
    
    Box(
        modifier
            .size(60.dp)
            .clip(CircleShape)
            .background(color = primary)
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ) { 
        Icon(
            imageVector = icon,
            contentDescription = contentDescription,
            tint = onPrimary,
            modifier = Modifier.size(iconSize)
        )
    }
    
}

@Preview
@Composable
private fun AlarmelFloatingActionButtonPreview() {
    AlarmelTheme {
        AlarmelFloatingActionButton(
            icon = Icons.Default.Cloud,
            onClick = {}
        )
    }
}