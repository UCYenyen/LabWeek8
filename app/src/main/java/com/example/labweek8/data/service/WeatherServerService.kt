package com.example.labweek8.data.service

import com.example.labweek8.data.dto.ResponseWeather
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherServerService {
    @GET("2.5/weather")
    suspend fun getWeatherByCity(
        @Query("q") cityName: String,
        @Query("appid") apiKey: String = "4f227bba54738695e4b77f659993c792",
        @Query("units") units: String = "metric"
    ): Response<ResponseWeather>
}