package com.danzucker.alarmel.alarm.alarmsettings.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.danzucker.alarmel.ui.theme.AlarmelTheme
import com.danzucker.alarmel.ui.theme.backgroundLightGrey
import com.danzucker.alarmel.ui.theme.lightGrey
import com.danzucker.alarmel.ui.theme.primary

@Composable
fun EditableTimeBox(
    state: TextFieldState,
    modifier: Modifier = Modifier
) {
    var isFocused by remember {
        mutableStateOf(false)
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .size(130.dp)
            .background(backgroundLightGrey, shape = RoundedCornerShape(10.dp))
    ) {
        BasicTextField(
            state = state,
            textStyle = LocalTextStyle.current.copy(
                color = lightGrey,
                textAlign = TextAlign.Center,
                lineHeight = 63.sp,
                fontSize = 36.sp
            ),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
            lineLimits = TextFieldLineLimits.SingleLine,
            cursorBrush = SolidColor(primary),
            modifier = Modifier
                .fillMaxWidth()
                .background(color = backgroundLightGrey, shape = RoundedCornerShape(10.dp))
                .onFocusChanged {
                    isFocused = it.isFocused
                },
            decorator = { innerTextField ->
                if (state.text.isEmpty()) {
                    Text(
                        text = "00",
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.titleLarge.copy(
                            color = lightGrey, // change later
                            fontSize = 52.sp,
                            lineHeight = 63.sp,
                            fontWeight = FontWeight.Medium
                        )
                    )
                }
                innerTextField()
            }
        )
    }
}


@Composable
fun EditableTimeMinuteBox(
    state: TextFieldState,
    modifier: Modifier = Modifier
) {
    var isFocused by remember {
        mutableStateOf(false)
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .size(130.dp)
            .background(backgroundLightGrey, shape = RoundedCornerShape(10.dp))
    ) {
        BasicTextField(
            state = state,
            textStyle = LocalTextStyle.current.copy(
                color = lightGrey,
                textAlign = TextAlign.Center,
                lineHeight = 63.sp,
                fontSize = 36.sp
            ),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
            lineLimits = TextFieldLineLimits.SingleLine,
            cursorBrush = SolidColor(primary),
            modifier = Modifier
                .fillMaxWidth()
                .background(color = backgroundLightGrey, shape = RoundedCornerShape(10.dp))
                .onFocusChanged {
                    isFocused = it.isFocused
                },
            decorator = { innerTextField ->
                if (state.text.isEmpty() && !isFocused) {
                    Text(
                        text = "00",
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.titleLarge.copy(
                            color = lightGrey, // change later
                            fontSize = 52.sp,
                            lineHeight = 63.sp,
                            fontWeight = FontWeight.Medium
                        )
                    )
                }
                innerTextField()
            }
        )
    }
}



@Preview
@Composable
private fun EditableTimeBoxPreview() {
    AlarmelTheme {
        EditableTimeBox(
            state = rememberTextFieldState()
        )
    }
}