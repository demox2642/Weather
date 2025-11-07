package com.demox.core.data.database.tables.hour

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = HourTableConteins.TABLE_NAME)
data class HourTable(
    @ColumnInfo(name = HourTableConteins.Colums.CHANCE_OF_RAIN)
    val chanceOfRain: Int,
    @ColumnInfo(name = HourTableConteins.Colums.CHANCE_OF_SNOW)
    val chanceOfSnow: Int,
    @ColumnInfo(name = HourTableConteins.Colums.CLOUD)
    val cloud: Int,
    @ColumnInfo(name = HourTableConteins.Colums.CONDITION_CODE)
    val conditionCode: Int,
    @ColumnInfo(name = HourTableConteins.Colums.DEW_POINT_C)
    val dewPointC: Double,
    @ColumnInfo(name = HourTableConteins.Colums.DEW_POINT_F)
    val dewPointF: Double,
    @ColumnInfo(name = HourTableConteins.Colums.FEELS_LIKE_C)
    val feelsLikeC: Double,
    @ColumnInfo(name = HourTableConteins.Colums.FEELS_LIKE_F)
    val feelsLikeF: Double,
    @ColumnInfo(name = HourTableConteins.Colums.GUST_KPH)
    val gustKph: Double,
    @ColumnInfo(name = HourTableConteins.Colums.GUST_MPH)
    val gustMph: Double,
    @ColumnInfo(name = HourTableConteins.Colums.HEAT_INDEX_C)
    val heatIndexC: Double,
    @ColumnInfo(name = HourTableConteins.Colums.HEAT_INDEX_F)
    val heatIndexF: Double,
    @ColumnInfo(name = HourTableConteins.Colums.HUMIDITY)
    val humidity: Int,
    @ColumnInfo(name = HourTableConteins.Colums.IS_DAY)
    val isDay: Int,
    @ColumnInfo(name = HourTableConteins.Colums.PRE_CIP_IN)
    val preCipIn: Double,
    @ColumnInfo(name = HourTableConteins.Colums.PRE_CIP_MM)
    val preCipMm: Double,
    @ColumnInfo(name = HourTableConteins.Colums.PRESSURE_IN)
    val pressureIn: Double,
    @ColumnInfo(name = HourTableConteins.Colums.PRESSURE_MB)
    val pressureMb: Double,
    @ColumnInfo(name = HourTableConteins.Colums.SNOW_CM)
    val snowCm: Double,
    @ColumnInfo(name = HourTableConteins.Colums.TEMP_C)
    val tempC: Double,
    @ColumnInfo(name = HourTableConteins.Colums.TEMP_F)
    val tempF: Double,
    @ColumnInfo(name = HourTableConteins.Colums.TIME)
    val time: String,
    @ColumnInfo(name = HourTableConteins.Colums.TIME_EPOCH)
    @PrimaryKey(autoGenerate = false)
    val timeEpoch: Long,
    @ColumnInfo(name = HourTableConteins.Colums.UV)
    val uv: Double,
    @ColumnInfo(name = HourTableConteins.Colums.VIS_KM)
    val visKm: Double,
    @ColumnInfo(name = HourTableConteins.Colums.VIS_MILES)
    val visMiles: Double,
    @ColumnInfo(name = HourTableConteins.Colums.WILL_IT_RAIN)
    val willItRain: Int,
    @ColumnInfo(name = HourTableConteins.Colums.WILL_IT_SNOW)
    val willItSnow: Int,
    @ColumnInfo(name = HourTableConteins.Colums.WIND_DEGREE)
    val windDegree: Int,
    @ColumnInfo(name = HourTableConteins.Colums.WIND_DIR)
    val windDir: String,
    @ColumnInfo(name = HourTableConteins.Colums.WIND_KPH)
    val windKph: Double,
    @ColumnInfo(name = HourTableConteins.Colums.WIND_MPH)
    val windMph: Double,
    @ColumnInfo(name = HourTableConteins.Colums.WINDCHILL_C)
    val windchillC: Double,
    @ColumnInfo(name = HourTableConteins.Colums.WINDCHILL_F)
    val windchillF: Double
)
