package com.kodeco.android.coordplot

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kodeco.android.coordplot.ui.theme.MyApplicationTheme


@Composable
fun MapComposable() {
    var xSliderValue by remember { mutableFloatStateOf(0.5f) }
    var ySliderValue by remember { mutableFloatStateOf(0.5f) }

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
