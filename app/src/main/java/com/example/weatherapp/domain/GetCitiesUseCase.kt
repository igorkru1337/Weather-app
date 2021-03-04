package com.example.weatherapp.domain

class GetCitiesUseCase(private val repository: CityRepository) {

    operator fun invoke(): List<City> = repository.getCities()
}