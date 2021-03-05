package com.example.weatherapp

import com.example.weatherapp.data.CityDataSource
import com.example.weatherapp.data.CityDataSourceImpl
import com.example.weatherapp.data.CityRepositoryImpl
import com.example.weatherapp.domain.CityRepository
import com.example.weatherapp.domain.GetCitiesUseCase
import com.example.weatherapp.domain.GetCityUseCase
import com.example.weatherapp.presentation.detail.WeatherCityViewModel
import com.example.weatherapp.presentation.list.ListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { (long: Long) -> WeatherCityViewModel(get(), long) }
    viewModel { ListViewModel(get()) }
    factory { GetCitiesUseCase(get()) }
    factory { GetCityUseCase(get()) }
    factory<CityRepository> { CityRepositoryImpl(get()) }
    factory<CityDataSource> { CityDataSourceImpl() }
}