package com.example.weatherapp

import android.app.Application
import com.example.weatherapp.domain.CityRepository

class CityApplication : Application(){

    lateinit var cityRepository: CityRepository

    override fun onCreate() {
        super.onCreate()
    }
}