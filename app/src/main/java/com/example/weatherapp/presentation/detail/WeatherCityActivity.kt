package com.example.weatherapp.presentation.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.weatherapp.R
import com.example.weatherapp.domain.City
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class WeatherCityActivity : AppCompatActivity() {

    companion object {

        private const val EXTRA_ID = "EXTRA_ID"

        fun start(context: Context, id: Long) {
            val intent = Intent(context, WeatherCityActivity::class.java)
            intent.putExtra(EXTRA_ID, id)
            context.startActivity(intent)
        }
    }

    private val viewModel: WeatherCityViewModel by viewModel {
        parametersOf(intent.getLongExtra(EXTRA_ID, 0))
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

    private fun closeScreen() {
        finish()
    }
}
