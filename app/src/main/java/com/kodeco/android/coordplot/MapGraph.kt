package com.kodeco.android.coordplot

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kodeco.android.coordplot.ui.theme.MyApplicationTheme

@Composable
fun MapGraph(xPercent: Float, yPercent: Float, mapSize: Int, cursorSize: Int) {
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

@Preview
@Composable
fun MapGraphPreview() {
    val xPercent = .5f
    val yPercent = .5f
    val mapSize = 300
    val cursorSize = 36
    MyApplicationTheme {
        MapGraph(xPercent, yPercent, mapSize, cursorSize)
    }
}
