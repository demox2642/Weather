package com.demox.feature.main.domain.models

data class CurrentWeatherData(
    val astroData: AstroData,
    val currentData: CurrentData,
    val locationData: LocationData,
    val hoursData: List<HourData>,
    val daysData: List<DayData>
)
