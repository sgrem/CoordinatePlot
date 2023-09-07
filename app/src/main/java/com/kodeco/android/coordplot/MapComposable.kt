package com.kodeco.android.coordplot

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kodeco.android.coordplot.ui.theme.MyApplicationTheme


@Composable
fun MapComposable() {
    var xSliderValue by remember { mutableStateOf(0.5f) }
    var ySliderValue by remember { mutableStateOf(0.5f) }

    Column( horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        MapGraph(xSliderValue, ySliderValue, mapSize = 300, cursorSize = 36)
        Spacer(modifier = Modifier.size(20.dp))
        Slider(
            value = xSliderValue,
            onValueChange = { newValue ->
                xSliderValue = newValue
            },
            valueRange = 0f..1.0f
        )
        Slider(
            value = ySliderValue,
            onValueChange = { newValue ->
                ySliderValue = newValue
            },
            valueRange = 0f..1.0f
        )
        SliderValues(xSliderValue, ySliderValue)
    }
}
@Composable
fun MapGraph(xPercent: Float, yPercent: Float, mapSize: Int, cursorSize: Int) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(modifier = Modifier
            .size((mapSize + cursorSize).dp)
            .background(Color.LightGray)) {
            Box(
                modifier = Modifier
                    .size(cursorSize.dp)
                    .offset((xPercent * mapSize).dp, (yPercent * mapSize).dp)
                    .clip(CircleShape)
                    .background(Color.Blue)
            )
        }
    }
}


@Composable
fun SliderValues(xSliderValue: Float, ySliderValue: Float) {
    Text(text = "X Slider Value: $xSliderValue")
    Text(text = "Y Slider Value: $ySliderValue")
}

@Preview(showBackground = true)
@Composable
fun MapComposablePreview() {
    MyApplicationTheme {
        MapComposable()
    }
}