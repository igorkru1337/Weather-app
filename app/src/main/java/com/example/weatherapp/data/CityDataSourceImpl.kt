package com.example.weatherapp.data

import com.example.weatherapp.domain.City
import kotlin.random.Random

class CityDataSourceImpl : CityDataSource {

    private val cities = mutableListOf(
        City(id = 0, name = "Novosibirsk", weatherForWeek = randomWeather()),
        City(id = 1, name = "Nur-Sultan", weatherForWeek = randomWeather()),
        City(id = 2, name = "Syktyvkar", weatherForWeek = randomWeather()),
        City(id = 3, name = "Nijniy Tagil", weatherForWeek = randomWeather()),
        City(id = 4, name = "Yurga", weatherForWeek = randomWeather()),
        City(id = 5, name = "Moscow", weatherForWeek = randomWeather()),
        City(id = 6, name = "Saint-Petersburg", weatherForWeek = randomWeather())
    )

    override fun getCity(id: Long): City? = cities.firstOrNull { it.id == id }

    override fun getCities(): List<City> = cities
}

internal fun randomWeather(): MutableList<String> {
    val list: MutableList<String> = mutableListOf()

    repeat(7) {
        list.add(
            index = it,
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