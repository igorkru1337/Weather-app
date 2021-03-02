package com.example.weatherapp.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weatherapp.City
import com.example.weatherapp.CityRepository
import com.example.weatherapp.LiveEvent

class WeatherCityViewModel(
        private val repository: CityRepository,
        id: Long
) : ViewModel() {

    val city = MutableLiveData<City>()

    val closeScreenEvent = LiveEvent()

    init {
        val city = repository.getCity(id)

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