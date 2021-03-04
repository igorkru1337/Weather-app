package com.example.weatherapp.presentation.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.weatherapp.data.CityDataSourceImpl
import com.example.weatherapp.data.CityRepositoryImpl
import com.example.weatherapp.domain.GetCitiesUseCase

class ListViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        val cityDataSource = CityDataSourceImpl()
        val cityRepository = CityRepositoryImpl(cityDataSource)
        val getCitiesUseCase = GetCitiesUseCase(cityRepository)

        return modelClass
            .getConstructor(GetCitiesUseCase::class.java)
            .newInstance(getCitiesUseCase)
    }
}