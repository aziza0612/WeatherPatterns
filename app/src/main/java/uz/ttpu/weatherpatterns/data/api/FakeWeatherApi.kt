
package uz.ttpu.weatherpatterns.data.api

import kotlinx.coroutines.delay
import uz.ttpu.weatherpatterns.data.model.Weather

class FakeWeatherApi(
    private val latencyMs: Long = 1_500
) : WeatherApi {

    override suspend fun fetchWeather(city: String): Weather {
        delay(latencyMs)

        return when (city.lowercase()) {
            "tashkent" -> Weather("Tashkent", 24, "Sunny")
            "samarkand" -> Weather("Samarkand", 21, "Cloudy")
            "bukhara" -> Weather("Bukhara", 27, "Windy")
            else -> throw IllegalArgumentException(
                "Unknown city: $city"
            )
        }
    }
}
