package com.example.labweek8.ui.view.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.labweek8.R
import com.example.labweek8.ui.model.WeatherItem
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Date
import java.util.Locale

@Composable
fun WeatherSuccessView(data: WeatherItem) {
    val timeFormatter = DateTimeFormatter.ofPattern("h:mm a", Locale.ENGLISH)
    val now = LocalDateTime.now()
    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(top = 14.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Default.LocationOn,
                    contentDescription = "Search Icon",
                    modifier = Modifier.size(24.dp),
                    tint = Color.White
                )
                Text(
                    text = "Kota ${data.cityName}",
                    color = Color.White,
                    fontWeight = FontWeight.Normal
                )
            }
        }
        item {
            Column (horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                Text(
                    text = SimpleDateFormat("MMMM dd", Locale.getDefault()).format(Date()),
                    color = Color.White,
                    fontSize = 42.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = "Updated as of ${now.format(timeFormatter)}",
                    color = Color.White.copy(alpha = 0.7f),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal
                )
            }
        }
        item {
            Spacer(modifier = Modifier.height(140.dp))
        }
        item {
            WeatherStatus(data)
        }
        item {
            Spacer(modifier = Modifier.height(24.dp))
        }
        item {
            GridWeatherStatus(data)
        }
        item {
            Spacer(modifier = Modifier.height(24.dp))
        }
        item {
            Row(modifier = Modifier.fillMaxWidth(),verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceEvenly) {
                WeatherSun(time = data.sunrise, label = "Sunrise", imgSrc = R.drawable.vector)
                WeatherSun(time = data.sunset, label = "Sunset", imgSrc = R.drawable.vector_21png)
            }
        }
    }
}