package com.example.weatherapp.domain

data class City(
        val id: Long,
        val name: String,
        val weatherForWeek: MutableList<String>
)