package com.example.weatherapp.list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.CityApplication
import com.example.weatherapp.CityRepository
import com.example.weatherapp.R
import com.example.weatherapp.detail.WeatherCityActivity
import com.example.weatherapp.list.ListAdapter

class ListCityActivity : AppCompatActivity() {

    private lateinit var cityRepository: CityRepository

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        cityRepository = (application as CityApplication).cityRepository

        setContentView(R.layout.list_city)
        val adapter = ListAdapter(cityRepository){
            WeatherCityActivity.start(this,it.id)
        }
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.adapter = adapter
    }

}