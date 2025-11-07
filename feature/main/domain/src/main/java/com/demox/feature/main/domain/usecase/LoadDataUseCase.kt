package com.demox.feature.main.domain.usecase

import com.demox.feature.main.domain.repository.WeatherRepository

class LoadDataUseCase(private val repository: WeatherRepository) {
    suspend fun loadData() = repository.loadData()
}