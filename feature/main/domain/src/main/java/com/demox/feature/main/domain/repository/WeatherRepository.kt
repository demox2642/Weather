package com.demox.feature.main.domain.repository

import com.demox.feature.main.domain.models.CurrentWeatherData

interface WeatherRepository {
    suspend fun loadData()
    suspend fun getWeatherCacheData(): CurrentWeatherData
}