package com.demox.feature.main.domain.usecase

import com.demox.feature.main.domain.repository.WeatherRepository

class GetWeatherCacheData(private val repository: WeatherRepository)  {
    suspend fun getWeatherCacheData() = repository.getWeatherCacheData()
}
