package com.example.weatherapp.presentation.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.weatherapp.data.CityDataSourceImpl
import com.example.weatherapp.data.CityRepositoryImpl
import com.example.weatherapp.domain.GetCityUseCase

class WeatherCityViewModelFactory(private val id: Long) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        val cityDataSource = CityDataSourceImpl()
        val cityRepository = CityRepositoryImpl(cityDataSource)
        val getCityUseCase = GetCityUseCase(cityRepository)

        return modelClass
            .getConstructor(
                GetCityUseCase::class.java,
                Long::class.java
            )
            .newInstance(getCityUseCase, id)
    }
}