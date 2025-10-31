package com.example.labweek8.data.repository

import com.example.labweek8.data.dto.ResponseWeather
import com.example.labweek8.data.service.WeatherServerService
import com.example.labweek8.ui.model.WeatherItem

class WeatherServerRepository(private val service: WeatherServerService) {
    suspend fun getWeatherByCity(cityName: String) : WeatherItem {
        val response = service.getWeatherByCity(cityName).body()!!
        val weatherItem = WeatherItem(
            icon = response.weather[0].icon,
            humidity = response.main.humidity.toString() + "%",
            wind_speed = response.wind.speed.toString() + "km/h",
            condition = response.weather[0].description,
            temperature = response.main.temp.toString() + "°",
            feels_like = response.main.feels_like.toString() + "°",
            rain_fall = (response.rain?.`1h` ?: 0.0).toString() + "mm",
            pressure = response.main.pressure.toString() + "hPa",
            sunrise = response.sys.sunrise,
            sunset = response.sys.sunset,
            cityName = response.name,
            cloud_percentage = response.clouds.all.toString() + "%"
        )
        return weatherItem
    }
}