package com.example.weatherapp.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.weatherapp.City
import com.example.weatherapp.CityApplication
import com.example.weatherapp.CityRepository
import com.example.weatherapp.R

class WeatherCityActivity : AppCompatActivity() {

    companion object {

        private const val EXTRA_ID = "EXTRA_ID"

        fun start(context: Context, id: Long) {
            val intent = Intent(context, WeatherCityActivity::class.java)
            intent.putExtra(EXTRA_ID, id)
            context.startActivity(intent)
        }
    }

    private val viewModel: WeatherCityViewModel by viewModels {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T =
                modelClass
                    .getConstructor(CityRepository::class.java, Long::class.java)
                    .newInstance(
                        (application as CityApplication).cityRepository,
                        intent.getLongExtra(EXTRA_ID, 0)
                    )
        }
    }

    private lateinit var weatherImage: ImageView
    private lateinit var tableLayout: TableLayout
    private lateinit var backButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.weather_for_week)
        viewModel.city.observe(this, ::bindCity)
        viewModel.closeScreenEvent.observe(this) { closeScreen() }

        initViews()
    }

    fun bindCity(city: City) {
        repeat(city.weatherForWeek.count()) {
            val textViewDay = TextView(tableLayout.context)
            val textViewWeather = TextView(tableLayout.context)
            val row = TableRow(tableLayout.context)

            textViewDay.text = when (it) {
                0 -> "Today"
                1 -> "Tomorrow"
                else -> "Through $it day"
            }

            textViewWeather.text = city.weatherForWeek[it]
            row.dividerDrawable = getDrawable(R.color.black)
            row.showDividers = LinearLayout.SHOW_DIVIDER_MIDDLE

            row.setPadding(8, 8, 8, 8)

            row.addView(textViewDay)
            row.addView(textViewWeather)


            tableLayout.addView(row)

            weatherImage.setImageResource(
                when (city.weatherForWeek[0]) {
                    "Sunny" -> R.drawable.weather_sunny
                    "Rainy" -> R.drawable.weather_rainy
                    "Cloudy" -> R.drawable.weather_cloudy
                    "Snowy" -> R.drawable.weather_snowy
                    else -> R.drawable.weather_lightning
                }
            )

            backButton.setOnClickListener {
                viewModel.closeView()
            }
        }
    }


    private fun initViews() {
        weatherImage = findViewById(R.id.weatherImage)
        tableLayout = findViewById(R.id.tableLayout)
        backButton = findViewById(R.id.backButton)
    }

    private fun closeScreen(){
        finish()
    }
}
