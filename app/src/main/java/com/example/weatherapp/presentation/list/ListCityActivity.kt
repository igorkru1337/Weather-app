package com.example.weatherapp.presentation.list

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.domain.City
import com.example.weatherapp.CityApplication
import com.example.weatherapp.domain.CityRepository
import com.example.weatherapp.R
import com.example.weatherapp.presentation.detail.WeatherCityActivity

class ListCityActivity : AppCompatActivity() {

    private val viewModel: ListViewModel by viewModels {
        ListViewModelFactory()
    }

    private lateinit var recyclerView: RecyclerView

    val adapter = ListAdapter {
        WeatherCityActivity.start(this, it.id)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_city)
        viewModel.cityList.observe(this, ::bindCityList)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.adapter = adapter
    }

    private fun bindCityList(list: List<City>){
        adapter.cities = list
    }

    override fun onResume() {
        super.onResume()
        viewModel.loadCities()
    }

}