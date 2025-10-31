package com.example.labweek8.ui.model

import com.example.labweek8.data.dto.Wind

data class WeatherItem(
    val icon: String,
    val humidity: String,
    val wind_speed: String,
    val condition: String,
    val temperature: String,
    val feels_like: String,
    val rain_fall: String,
    val pressure: String,
    val sunrise: Int,
    val sunset: Int,
    val cityName: String,
    val cloud_percentage: String
)