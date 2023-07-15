package com.arstagaev.solarpanelx.domain.interactor

import com.arstagaev.solarpanelx.domain.model.Weather
import com.arstagaev.solarpanelx.repository.IWeatherRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GetWeatherByCityUseCase: KoinComponent, BaseUseCase<String, Weather> {
    private val repository: IWeatherRepository by inject()
    override suspend fun invoke(cityName: String) = repository.getWeatherByCity(cityName)
}
