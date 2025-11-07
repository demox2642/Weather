package com.demox.core.data.database.tables.day

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = DayTableConteins.TABLE_NAME,
    indices = [Index( DayTableConteins.Colums.DATE_EPOCH)],
)

data class DayTable(
    @ColumnInfo(name = DayTableConteins.Colums.DATE_EPOCH)
    @PrimaryKey(autoGenerate = false)
    val dateEpoch: Long,
    @ColumnInfo(name = DayTableConteins.Colums.AVG_HUMIDITY)
    val avgHumidity: Int,
    @ColumnInfo(name = DayTableConteins.Colums.AVG_TEMP_C)
    val avgTempC: Double,
    @ColumnInfo(name = DayTableConteins.Colums.AVG_TEMP_F)
    val avgTempF: Double,
    @ColumnInfo(name = DayTableConteins.Colums.AVG_VIS_KM)
    val avgVisKm: Double,
    @ColumnInfo(name = DayTableConteins.Colums.AVG_VIS_MILES)
    val avgVisMiles: Double,
    @ColumnInfo(name = DayTableConteins.Colums.CONDITION_CODE)
    val conditionCode: Int,
    @ColumnInfo(name = DayTableConteins.Colums.DAILY_CHANCE_OF_RAIN)
    val dailyChanceOfRain: Int,
    @ColumnInfo(name = DayTableConteins.Colums.DAILY_CHANCE_OF_SNOW)
    val dailyChanceOfSnow: Int,
    @ColumnInfo(name = DayTableConteins.Colums.DAILY_WILL_IT_RAIN)
    val dailyWillItRain: Int,
    @ColumnInfo(name = DayTableConteins.Colums.DAILY_WILL_IT_SNOW)
    val dailyWillItSnow: Int,
    @ColumnInfo(name = DayTableConteins.Colums.MAX_TEMP_C)
    val maxTempC: Double,
    @ColumnInfo(name = DayTableConteins.Colums.MAX_TEMP_F)
    val maxTempF: Double,
    @ColumnInfo(name = DayTableConteins.Colums.MAX_WIND_KPH)
    val maxWindKph: Double,
    @ColumnInfo(name = DayTableConteins.Colums.MAX_WIND_MPH)
    val maxWindMph: Double,
    @ColumnInfo(name = DayTableConteins.Colums.MIN_TEMP_C)
    val minTempC: Double,
    @ColumnInfo(name = DayTableConteins.Colums.MIN_TEMP_F)
    val minTempF: Double,
    @ColumnInfo(name = DayTableConteins.Colums.TOTAL_PRECIP_IN)
    val totalPrecipIn: Double,
    @ColumnInfo(name = DayTableConteins.Colums.TOTAL_PRECIP_MM)
    val totalPrecipMm: Double,
    @ColumnInfo(name = DayTableConteins.Colums.TOTAL_SNOW_CM)
    val totalSnowCm: Double,
    @ColumnInfo(name = DayTableConteins.Colums.UV)
    val uv: Double
)
