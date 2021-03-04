package com.example.weatherapp.domain

class GetCityUseCase(private val repository: CityRepository) {

    operator fun invoke(id: Long): City? = repository.getCity(id)
}