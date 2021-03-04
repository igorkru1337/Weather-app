package com.example.weatherapp.data

import com.example.weatherapp.domain.City

interface CityDataSource {

    fun getCity(id: Long): City?

    fun getCities(): List<City>
}