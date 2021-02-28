package com.example.weatherapp

import com.example.weatherapp.City
import kotlin.random.Random

class CityRepository {

    private var cities : MutableList<City> = mutableListOf()

    fun getCity(id: Long): City? = cities.firstOrNull { it.id == id }

    fun getCities(): List<City> = cities

    fun createList(){
        cities = mutableListOf(
                City(id = 0, name = "Novosibirsk", weatherForWeek = randomWeather()),
                City(id = 1, name = "Nur-Sultan", weatherForWeek = randomWeather()),
                City(id = 2, name = "Syktyvkar", weatherForWeek = randomWeather()),
                City(id = 3, name = "Nijniy Tagil", weatherForWeek = randomWeather()),
                City(id = 4, name = "Yurga", weatherForWeek = randomWeather()),
                City(id = 5, name = "Moscow", weatherForWeek = randomWeather()),
                City(id = 6, name = "Saint-Petersburg", weatherForWeek = randomWeather())
        )
    }

    private fun randomWeather(): MutableList<String> {
        val list: MutableList<String> = mutableListOf()

        repeat(7) {
            list.add(index = it,
                    when (Random.nextInt(5)) {
                        0 -> "Sunny"
                        1 -> "Cloudy"
                        2 -> "Rainy"
                        3 -> "Lightning"
                        else -> "Snowy"
                    }
            )
        }
        return list
    }
}

