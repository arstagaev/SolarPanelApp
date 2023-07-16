package com.arstagaev.solarpanelx.data.remote

import com.arstagaev.solarpanelx.data.remote.NetworkConstants
import com.arstagaev.solarpanelx.data.remote.models.WeatherDto
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class WeatherClient(
    private val client: HttpClient
) {

    suspend fun getWeatherByCity(cityName: String): WeatherDto =
        client.get(NetworkConstants.City.byName(cityName)).body<WeatherDto>()

}