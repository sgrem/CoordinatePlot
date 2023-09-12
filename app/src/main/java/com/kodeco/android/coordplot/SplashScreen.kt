package com.kodeco.android.coordplot

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import kotlinx.coroutines.delay

@Composable
fun SplashScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text("Welcome to the Coordinate Plot App")
    }
}

@Composable
fun SplashScreenWithNavigation(navController: NavController) {
    LaunchedEffect(Unit) {
        delay(3000)  // Delay for 3 seconds
        navController.navigate("main_screen")
    }
    SplashScreen()
}

