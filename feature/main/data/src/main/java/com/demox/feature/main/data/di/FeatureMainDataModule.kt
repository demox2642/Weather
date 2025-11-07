package com.demox.feature.main.data.di

import com.demox.core.data.database.tables.astro.AstroTableDao
import com.demox.core.data.database.tables.condition.ConditionTableDao
import com.demox.core.data.database.tables.current.CurrentTableDao
import com.demox.core.data.database.tables.day.DayTableDao
import com.demox.core.data.database.tables.hour.HourTableDao
import com.demox.core.data.database.tables.location.LocationTableDao
import com.demox.feature.main.data.api.WeatherApi
import com.demox.feature.main.data.repository.WeatherRepositoryImpl
import com.demox.feature.main.domain.repository.WeatherRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FeatureMainDataModule {
    @Singleton
    @Provides
    fun provideWeatherApi(retrofit: Retrofit.Builder): WeatherApi {
        return retrofit.build()
            .create(WeatherApi::class.java)
    }

    @Singleton
    @Provides
    fun provideWeatherRepository(
        astroTableDao : AstroTableDao,
        conditionTableDao : ConditionTableDao,
        currentTableDao : CurrentTableDao,
        dayTableDao : DayTableDao,
        hourTableDao : HourTableDao,
        locationTableDao : LocationTableDao,
        weatherApi: WeatherApi,
    ): WeatherRepository {
        return WeatherRepositoryImpl(
            astroTableDao = astroTableDao,
            conditionTableDao = conditionTableDao,
            currentTableDao = currentTableDao,
            dayTableDao = dayTableDao,
            hourTableDao = hourTableDao,
            locationTableDao = locationTableDao,
            weatherApi = weatherApi
        )
    }
}