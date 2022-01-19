package com.ders.weather_json.model

data class Weather(
    val description: String,
    val icon: String,
    val id: Int,
    val main: String
)