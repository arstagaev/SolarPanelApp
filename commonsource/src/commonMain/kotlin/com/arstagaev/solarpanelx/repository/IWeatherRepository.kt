package com.arstagaev.solarpanelx.repository

import com.arstagaev.solarpanelx.domain.model.Weather

interface IWeatherRepository {
    suspend fun getWeatherByCity(cityName: String): Weather
}