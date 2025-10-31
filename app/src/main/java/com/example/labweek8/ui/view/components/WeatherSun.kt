package com.example.labweek8.ui.view.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.Locale

@Composable
fun WeatherSun(time: Int, label: String, imgSrc: Int) {
    val timeFormatter = DateTimeFormatter.ofPattern("h:mm a", Locale.ENGLISH)
    val timestamp: Long = 0
    val instant = Instant.ofEpochSecond(timestamp)
    val localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault())
    val formattedTime = timeFormatter.format(localDateTime)

    Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(imgSrc),
            contentDescription = label,
            modifier = Modifier.size(48.dp)
        )
        Text(label.uppercase(Locale.ROOT), textAlign = TextAlign.Center, color = Color.White.copy(alpha = 0.5f))
        Text(formattedTime, textAlign = TextAlign.Center, color = Color.White, fontWeight = FontWeight.Bold)
    }
}