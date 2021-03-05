package com.example.weatherapp.domain

interface  CityRepository {

    fun getCity(id: Long): City?

    fun getCities(): List<City>
}

