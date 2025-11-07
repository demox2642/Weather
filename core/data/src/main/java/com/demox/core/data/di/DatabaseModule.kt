package com.demox.core.data.di

import android.content.Context
import androidx.room.Room
import com.demox.core.data.database.WeatherDataBase
import com.demox.core.data.database.tables.astro.AstroTableDao
import com.demox.core.data.database.tables.condition.ConditionTableDao
import com.demox.core.data.database.tables.current.CurrentTableDao
import com.demox.core.data.database.tables.day.DayTableDao
import com.demox.core.data.database.tables.hour.HourTableDao
import com.demox.core.data.database.tables.location.LocationTableDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Provides
    @Singleton
    fun provideWeatherDataBase(
        @ApplicationContext context: Context,
    ): WeatherDataBase =
        Room
            .databaseBuilder(
                context,
                WeatherDataBase::class.java,
                "WeatherDataBase",
            )
            .allowMainThreadQueries()
            .build()


    @Singleton
    @Provides
    fun provideGetAstroTableDao(
        database: WeatherDataBase,
    ): AstroTableDao =
        database.getAstroTableDao()

    @Singleton
    @Provides
    fun provideGetConditionTableDao(
        database: WeatherDataBase,
    ): ConditionTableDao =
        database.getConditionTableDao()

    @Singleton
    @Provides
    fun provideGetCurrentTableDao(
        database: WeatherDataBase,
    ): CurrentTableDao =
        database.getCurrentTableDao()

    @Singleton
    @Provides
    fun provideGetDayTableDao(
        database: WeatherDataBase,
    ): DayTableDao =
        database.getDayTableDao()

    @Singleton
    @Provides
    fun provideGetHourTableDao(
        database: WeatherDataBase,
    ): HourTableDao =
        database.getHourTableDao()

    @Singleton
    @Provides
    fun provideGetLocationTableDao(
        database: WeatherDataBase,
    ): LocationTableDao =
        database.getLocationTableDao()

}