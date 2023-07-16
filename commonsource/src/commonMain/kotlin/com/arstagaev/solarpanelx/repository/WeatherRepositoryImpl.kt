package com.arstagaev.solarpanelx.repository

import com.arstagaev.solarpanelx.data.mapper.prepareToUI
import com.arstagaev.solarpanelx.data.remote.WeatherClient
import com.arstagaev.solarpanelx.domain.model.Weather
import com.arstagaev.solarpanelx.util.DateTimeUtil
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

internal class WeatherRepositoryImpl(
): IWeatherRepository, KoinComponent {

    private val weatherClient by inject<WeatherClient>()
    //private val weatherDao by inject<WeatherDao>()

    override suspend fun getWeatherByCity(cityName: String): Weather {
        //weatherDao.insert(Cityw(cityName,"${DateTimeUtil.nowTime()}"))
        return weatherClient.getWeatherByCity(cityName).prepareToUI()
    }


}
