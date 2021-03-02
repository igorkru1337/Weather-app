package com.example.weatherapp.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weatherapp.City
import com.example.weatherapp.CityRepository

class ListViewModel(private val repository: CityRepository) : ViewModel() {

    val cityList = MutableLiveData<List<City>>()

    fun loadCities(){
        val cities = repository.getCities()

        cityList.value = cities
    }
}