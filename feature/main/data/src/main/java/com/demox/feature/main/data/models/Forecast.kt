package com.demox.feature.main.data.models

import com.demox.feature.main.data.models.ForecastDay
import com.google.gson.annotations.SerializedName

data class Forecast(
    @SerializedName("forecastday")
    val forecastDay: List<ForecastDay>
)