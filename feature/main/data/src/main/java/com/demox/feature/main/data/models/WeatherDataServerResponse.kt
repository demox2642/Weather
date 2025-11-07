package com.demox.feature.main.data.models

data class WeatherDataServerResponse(
    val current: Current,
    val forecast: Forecast,
    val location: Location
)