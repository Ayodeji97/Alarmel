package com.danzucker.alarmel.alarm.core.presentation.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.danzucker.alarmel.R
import com.danzucker.alarmel.ui.theme.AlarmelTheme
import com.danzucker.alarmel.ui.theme.backgroundWhite
import com.danzucker.alarmel.ui.theme.contentDark
import com.danzucker.alarmel.ui.theme.inactiveGrey
import com.danzucker.alarmel.ui.theme.lightGrey

@Composable
fun AlarmelDialog(
    modifier: Modifier = Modifier
) {

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
            .shadow(
                elevation = 15.dp,
                spotColor = Color.Transparent,
                shape = RoundedCornerShape(10.dp)
            ),
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(
            containerColor = backgroundWhite,
            contentColor = contentDark
        )
    ) {
        Text(
            text = stringResource(R.string.alarm_name),
            style = MaterialTheme.typography.labelMedium,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, start = 16.dp, end = 16.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = "",
            onValueChange = {},
            placeholder = {
                Text(
                    text = stringResource(R.string.alarm_name),
                    style = MaterialTheme.typography.bodySmall,
                    color = lightGrey
                )
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done
            ),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = inactiveGrey
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp),
        )

        Spacer(modifier = Modifier.height(16.dp))

        AlarmelButton(
            onClick = {},
            buttonText = stringResource(R.string.save),
            modifier = Modifier
                .align(Alignment.End)
                .padding(end = 16.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
    }
}


@Preview
@Composable
private fun AlarmelDialogPreview() {
    AlarmelTheme {
        AlarmelDialog()
    }
}