package com.example.weatherapp.presentation.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weatherapp.domain.City
import com.example.weatherapp.domain.CityRepository
import com.example.weatherapp.domain.GetCityUseCase
import com.example.weatherapp.presentation.LiveEvent

class WeatherCityViewModel(
    getCityUseCase: GetCityUseCase,
    id: Long
) : ViewModel() {

    val city = MutableLiveData<City>()

    val closeScreenEvent = LiveEvent()

    init {
        val city = getCityUseCase(id)

        if(city != null){
            this.city.value = city
        } else {
            closeScreenEvent(Unit)
        }
    }

    fun closeView(){
        closeScreenEvent(Unit)
    }
}