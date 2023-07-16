package com.arstagaev.solarpanelx.domain.model

import com.arstagaev.solarpanelx.data.remote.models.Condition

data class Weather(
    val country: String,
    val lat: Double,
    val localtime: String,
    val lon: Double,
    val name: String,
    val region: String,

    val cloud: Int,
    val condition: Condition,
    val feelslike_c: Double,
)
