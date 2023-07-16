package com.arstagaev.solarpanelx.data.remote.models

import com.arstagaev.solarpanelx.data.remote.models.Current
import com.arstagaev.solarpanelx.data.remote.models.Location
import kotlinx.serialization.Serializable
@Serializable
data class WeatherDto(
    val current: Current,
    val location: Location
)