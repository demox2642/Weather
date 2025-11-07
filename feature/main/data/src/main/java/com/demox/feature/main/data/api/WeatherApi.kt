package com.demox.feature.main.data.api

import com.demox.feature.main.data.models.WeatherDataServerResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("v1/forecast.json")
    suspend fun getWeatherData(
        @Query("key") key: String? = "fa8b3df74d4042b9aa7135114252304",
        @Query("q") location: String? = "55.7569,37.6151",
        @Query("days") days: Int? = 3
    ): WeatherDataServerResponse
}