package com.danzucker.alarmel.alarm.alarmsettings.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TimeBox(
    time: String,
    onTimeChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .size(100.dp) // Adjust size as needed
            .background(Color(0xFFF5F5F5), RoundedCornerShape(8.dp))
            .border(1.dp, Color.Gray, RoundedCornerShape(8.dp)),
        contentAlignment = Alignment.Center
    ) {
        BasicTextField(
            value = time,
            onValueChange = { newValue ->
                if (newValue.length <= 2 && newValue.all { it.isDigit() }) {
                    onTimeChange(newValue)
                }
            },
            textStyle = TextStyle(
                color = Color(0xFF4285F4), // Google's Blue color
                fontSize = 36.sp,
                textAlign = TextAlign.Center
            ),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
            modifier = Modifier.fillMaxWidth(),
            decorationBox = { innerTextField ->
                if (time.isEmpty()) {
                    Text(
                        text = "00",
                        style = TextStyle(
                            color = Color.LightGray,
                            fontSize = 36.sp,
                            textAlign = TextAlign.Center
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
fun TimeBoxPreview() {
    var time by remember { mutableStateOf("") }

    TimeBox(
        time = time,
        onTimeChange = { time = it }
    )
}
