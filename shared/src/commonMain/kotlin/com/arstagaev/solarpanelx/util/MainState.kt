package com.arstagaev.solarpanelx.util

import com.arstagaev.solarpanelx.domain.model.Weather

data class MainState (
    val isLoading: Boolean = false,
    val error: String? = null,
    val success: Weather? = null
)