package com.example.labweek8.ui.view.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun WeatherErrorView(message: String) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterVertically)
    ) {
        Icon(imageVector = Icons.Default.Warning, contentDescription = "warning", tint = Color.Red, modifier = Modifier.size(72.dp))
        Text(
            "Oops! Something went wrong",
            textAlign = TextAlign.Center,
            color = Color.White
        )
        Text(
            message,
            textAlign = TextAlign.Center,
            color = Color.White.copy(alpha = 0.7f)
        )
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
private fun WeatherErrorViewPreview() {
    WeatherErrorView(message = "Unable to fetch weather data. Please try again later.")
}