package com.example.weatherapp

import android.app.Application

class CityApplication : Application(){

    lateinit var cityRepository: CityRepository

    override fun onCreate() {
        super.onCreate()
        cityRepository = CityRepository()
        cityRepository.createList()
    }
}