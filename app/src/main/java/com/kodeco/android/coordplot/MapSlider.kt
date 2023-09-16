package com.kodeco.android.coordplot

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kodeco.android.coordplot.ui.theme.MyApplicationTheme

@Composable
fun MapSlider(axisLabel: String,
              percentage: Float,
              onPercentageChange: (Float) -> Unit) {
    Row(verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(horizontal = 6.dp)) {
        Text("$axisLabel Axis: ${Math.round(percentage * 100)}%",
            modifier = Modifier.padding(start = 8.dp).width(120.dp))
        Slider(
            value = percentage,
            onValueChange = onPercentageChange
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MapSliderPreview() {
    MyApplicationTheme {
        MapSlider("X", 0.5f){}
    }
}

