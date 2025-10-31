package com.example.labweek8.ui.view.components

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.labweek8.R
import com.example.labweek8.data.dto.ResponseWeather
import com.example.labweek8.ui.model.WeatherItem

private data class WeatherInfo(
    val icon: Int,
    val label: String,
    val value: String
)

@Composable
fun GridWeatherStatus(weather: WeatherItem) {

    val weatherDetails = listOf(
        WeatherInfo(R.drawable.icon_humidity, "Humidity", weather.humidity),
        WeatherInfo(R.drawable.icon_wind, "Wind", weather.wind_speed),
        WeatherInfo(R.drawable.icon_feels_like, "Feels Like", weather.feels_like),
        WeatherInfo(R.drawable.vector_2, "Rain Fall", weather.rain_fall),
        WeatherInfo(R.drawable.devices, "Pressure", weather.pressure),
        WeatherInfo(R.drawable.cloud, "Clouds", weather.cloud_percentage)
    )

    val chunkedDetails = weatherDetails.chunked(3)

    Column(
        modifier = Modifier.padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        chunkedDetails.forEach { rowItems ->
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                rowItems.forEach { detail ->
                    WeatherDetailItem(
                        icon = detail.icon,
                        label = detail.label,
                        value = detail.value,
                        modifier = Modifier.weight(1f)
                    )
                }

                if (rowItems.size == 2) {
                    Spacer(Modifier.weight(1f))
                }
            }
        }
    }
}