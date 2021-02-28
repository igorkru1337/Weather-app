package com.example.weatherapp.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
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

    private lateinit var cityRepository: CityRepository

    private lateinit var weatherImage: ImageView
    private lateinit var tableLayout: TableLayout
    private lateinit var backButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        cityRepository = (application as CityApplication).cityRepository

        setContentView(R.layout.weather_for_week)

        initViews()
    }

    private fun initViews() {
        val id = intent.getLongExtra(EXTRA_ID, 0)
        val city = cityRepository.getCity(id)

        if (city != null) {
            weatherImage = findViewById(R.id.weatherImage)
            tableLayout = findViewById(R.id.tableLayout)
            backButton = findViewById(R.id.backButton)

            val textViewDay = TextView(tableLayout.context)
            val textViewWeather = TextView(tableLayout.context)
            repeat(city.weatherForWeek.count()) {
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
                    finish()
                }
            }
        } else {
            finish()
        }
    }
}