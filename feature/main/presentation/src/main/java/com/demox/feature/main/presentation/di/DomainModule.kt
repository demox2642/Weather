package com.demox.feature.main.presentation.di

import com.demox.feature.main.domain.repository.WeatherRepository
import com.demox.feature.main.domain.usecase.GetWeatherCacheData
import com.demox.feature.main.domain.usecase.LoadDataUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class DomainModule {

    @Provides
    fun providesLoadDataUseCase(repository: WeatherRepository) =
        LoadDataUseCase(repository)


    @Provides
    fun providesGetFilterCharacterListUseCase(repository: WeatherRepository) =
        GetWeatherCacheData(repository)
}