package com.example.weatherapp

data class City(
        val id: Long,
        val name: String,
        val weatherForWeek: MutableList<String>
)