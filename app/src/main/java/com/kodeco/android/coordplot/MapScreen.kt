package com.kodeco.android.coordplot

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Slider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kodeco.android.coordplot.ui.theme.MyApplicationTheme

@Composable
fun MapScreen(){
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Map(xPercent = 0.5f, yPercent = 0.5f)
        MapSlider()
        MapSlider()
    }
}

@Preview(showBackground = true)
@Composable
fun MapScreenPreview() {
    MyApplicationTheme {
        MapScreen()
    }
}

@Composable
fun MapSlider() {
    Slider(value = 0.5f,
        valueRange = 0.01f..1f,
        onValueChange = {} )
}

@Composable
fun Map(xPercent: Float, yPercent: Float) {
    Box(modifier = Modifier.size(300.dp)){
        Box(modifier = Modifier
            .size(36.dp)
            .offset((xPercent * 300 - 18).dp, (yPercent * 300 - 18).dp)
            .clip(CircleShape)
            .background(Color.Blue)
            )
    }
}

@Preview(showBackground = true)
@Composable
fun MapPreview() {
    MyApplicationTheme {
        Map(xPercent = 0.5f, yPercent = 0.5f)
    }
}