package com.example.weatherapp.data

import com.example.weatherapp.domain.City
import com.example.weatherapp.domain.CityRepository

class CityRepositoryImpl(private val cityDataSource: CityDataSource) : CityRepository {
    override fun getCity(id: Long): City? = cityDataSource.getCity(id)

    override fun getCities(): List<City> = cityDataSource.getCities()
}