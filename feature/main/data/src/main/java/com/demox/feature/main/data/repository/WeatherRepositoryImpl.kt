package com.demox.feature.main.data.repository

import com.demox.core.data.database.tables.astro.AstroTableDao
import com.demox.core.data.database.tables.condition.ConditionTableDao
import com.demox.core.data.database.tables.current.CurrentTableDao
import com.demox.core.data.database.tables.day.DayTableDao
import com.demox.core.data.database.tables.hour.HourTableDao
import com.demox.core.data.database.tables.location.LocationTableDao
import com.demox.core.data.ext.toShortDataString
import com.demox.feature.main.data.api.WeatherApi
import com.demox.feature.main.data.models.toAstroData
import com.demox.feature.main.data.models.toAstroTable
import com.demox.feature.main.data.models.toConditionData
import com.demox.feature.main.data.models.toConditionTable
import com.demox.feature.main.data.models.toCurrentData
import com.demox.feature.main.data.models.toCurrentTable
import com.demox.feature.main.data.models.toDayData
import com.demox.feature.main.data.models.toDayTable
import com.demox.feature.main.data.models.toHourData
import com.demox.feature.main.data.models.toHourTable
import com.demox.feature.main.data.models.toLocationData
import com.demox.feature.main.data.models.toLocationTable
import com.demox.feature.main.domain.models.CurrentWeatherData
import com.demox.feature.main.domain.repository.WeatherRepository
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val astroTableDao: AstroTableDao,
    private val conditionTableDao: ConditionTableDao,
    private val currentTableDao: CurrentTableDao,
    private val dayTableDao: DayTableDao,
    private val hourTableDao: HourTableDao,
    private val locationTableDao: LocationTableDao,
    private val weatherApi: WeatherApi
): WeatherRepository {
    override suspend fun loadData() {
        val response = weatherApi.getWeatherData()

        astroTableDao.clearTable()
        conditionTableDao.clearTable()
        currentTableDao.clearTable()
        dayTableDao.clearTable()
        hourTableDao.clearTable()
        locationTableDao.clearTable()

        locationTableDao.insert(response.location.toLocationTable())
        currentTableDao.insert(response.current.toCurrentTable())

        response.forecast.forecastDay.forEach { day->
            astroTableDao.insert(day.astro.toAstroTable(day.dateEpoch))
            conditionTableDao.insert(day.day.condition.toConditionTable())

            dayTableDao.insert(day.day.toDayTable(day.dateEpoch))
            day.hour.map {
                conditionTableDao.insert(it.condition.toConditionTable())
            }

            hourTableDao.insert(
              day.hour.map { it.toHourTable() }
            )

        }

    }


    override suspend fun getWeatherCacheData(): CurrentWeatherData {

        val currentDate = Date.from(java.time.Instant.now())
        val formatter = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())

        val astro = astroTableDao.getAstroList()
            .first {
                it.dateEpoch.toShortDataString() == formatter.format(currentDate) }
            .toAstroData()

        val current = currentTableDao.getCurrentTable()
        val hoursData = hourTableDao.getHourList()
            .filter {
                it.timeEpoch.toShortDataString() == formatter.format(currentDate)
            }
            .map {
                it.toHourData(conditionTableDao.getConditionByCode(it.conditionCode).toConditionData())
            }
            .sortedBy { it.timeEpoch }

        val days = dayTableDao.getDaysList()
            .map { it.toDayData(conditionTableDao.getConditionByCode(it.conditionCode).toConditionData()) }


        return CurrentWeatherData(
            astroData = astro,
            currentData = current.toCurrentData(conditionTableDao.getConditionByCode(current.conditionCode).toConditionData()),
            locationData = locationTableDao.getLocation().toLocationData(),
            hoursData = hoursData,
            daysData = days
        )
    }
}