package com.arstagaev.solarpanelx.di

import com.arstagaev.solarpanelx.data.remote.WeatherClient
import com.arstagaev.solarpanelx.data.remote.createHttpClient
import com.arstagaev.solarpanelx.repository.WeatherRepositoryImpl
import com.arstagaev.solarpanelx.domain.interactor.GetWeatherByCityUseCase
import com.arstagaev.solarpanelx.repository.IWeatherRepository
import org.koin.dsl.module

private val dataModule = module {
    single { createHttpClient(true) }
    single { WeatherClient(client = get()) }
}

private val dbModule = module {
//    factory { sqlDriverFactory() }
//    single { createDatabase(driver = get()) }
//    single { WeatherDao(weatherDatabase = get()) }

}
private val utilityModule = module {
    //factory { provideDispatcher }
}

private val domainModule = module {
    single<IWeatherRepository> {
        WeatherRepositoryImpl()
    }
    factory { GetWeatherByCityUseCase() }
}
val sharedModules = listOf(dataModule, utilityModule, domainModule, dbModule)