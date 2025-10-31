package com.example.labweek8.data.container

import com.example.labweek8.data.repository.WeatherServerRepository
import com.example.labweek8.data.service.WeatherServerService
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WeatherServerContainer {
    companion object {
        val BASE_URL = "https://api.openweathermap.org/data/"
        val BASE_IMG_URL = "https://openweathermap.org/img/wn/"
    }
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
        .baseUrl(BASE_URL)
        .build()

    private val retrofitService: WeatherServerService by lazy {
        retrofit.create(WeatherServerService::class.java)
    }

    val WeatherServerRepository : WeatherServerRepository by lazy {
        WeatherServerRepository(retrofitService)
    }
}