package com.example.labweek8.data.dto

data class ResponseWeather(
    val base: String,
    val clouds: Clouds,
    val cod: Int,
    val coord: Coord,
    val dt: Int,
    val id: Int,
    val main: Main,
    val name: String,
    val rain: Rain?,
    val sys: Sys,
    val visibilty: Int,
    val weather: List<Weather>,
    val wind: Wind
)