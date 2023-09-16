package com.kodeco.android.coordplot

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
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


    BoxWithConstraints {
        if (maxWidth < maxHeight) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                MapGraph(xSliderValue, ySliderValue, mapSize = 300, cursorSize = 36)
                Spacer(modifier = Modifier.size(20.dp))
                MapSlider(
                    "X",
                    percentage = xSliderValue
                ) { xSliderValue = it }
                MapSlider(
                    "Y",
                    percentage = ySliderValue
                ) { ySliderValue = it }
            }
        } else {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                MapGraph(xSliderValue, ySliderValue, mapSize = 300, cursorSize = 36)
                Column {
                    MapSlider(
                        "X",
                        percentage = xSliderValue
                    ) { xSliderValue = it }
                    MapSlider(
                        "Y",
                        percentage = ySliderValue
                    ) { ySliderValue = it }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MapComposablePreview() {
    MyApplicationTheme {
        MapComposable()
    }
}

