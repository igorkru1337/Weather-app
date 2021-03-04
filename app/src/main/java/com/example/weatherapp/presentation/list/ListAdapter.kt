package com.example.weatherapp.presentation.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.domain.City
import com.example.weatherapp.R

class ListAdapter(private val onClick: (City) -> Unit) : RecyclerView.Adapter<ListAdapter.CityHolder>() {

    var cities: List<City> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    class CityHolder(itemView: View, private val onClick: (City) -> Unit) : RecyclerView.ViewHolder(itemView) {

        val cityText: TextView = itemView.findViewById(R.id.cityText)
        val weatherText: TextView = itemView.findViewById(R.id.weatherText)
        val weatherImage: ImageView = itemView.findViewById(R.id.weatherImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_city, parent, false)
        return CityHolder(view, onClick)
    }

    override fun onBindViewHolder(holder: CityHolder, position: Int) {
        holder.cityText.text = cities[position].name
        holder.weatherText.text = cities[position].weatherForWeek[0]
        holder.weatherImage.setImageResource(
                when(cities[position].weatherForWeek[0]) {
                    "Sunny" -> R.drawable.weather_sunny
                    "Rainy" -> R.drawable.weather_rainy
                    "Cloudy" -> R.drawable.weather_cloudy
                    "Snowy" -> R.drawable.weather_snowy
                    else -> R.drawable.weather_lightning
                })
        holder.itemView.setOnClickListener { onClick(cities[position]) }
    }

    override fun getItemCount(): Int = cities.size
}