package com.demox.core.data.database.tables.current

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = CurrentTableConteins.TABLE_NAME,
    indices = [Index( CurrentTableConteins.Colums.LAST_UPDATED_EPOCH)],
)
data class CurrentTable(
    @ColumnInfo(name = CurrentTableConteins.Colums.CLOUD)
    val cloud: Int,
    @ColumnInfo(name = CurrentTableConteins.Colums.CONDITION_CODE)
    val conditionCode: Int,
    @ColumnInfo(name = CurrentTableConteins.Colums.DEW_POINT_C)
    val dewPointC: Double,
    @ColumnInfo(name = CurrentTableConteins.Colums.DEW_POINT_F)
    val dewPointF: Double,
    @ColumnInfo(name = CurrentTableConteins.Colums.FEELS_LIKE_C)
    val feelsLikeC: Double,
    @ColumnInfo(name = CurrentTableConteins.Colums.FEELS_LIKE_F)
    val feelsLikeF: Double,
    @ColumnInfo(name = CurrentTableConteins.Colums.GUST_KPH)
    val gustKph: Double,
    @ColumnInfo(name = CurrentTableConteins.Colums.GUST_MPH)
    val gustMph: Double,
    @ColumnInfo(name = CurrentTableConteins.Colums.HEAT_INDEX_C)
    val heatIndexC: Double,
    @ColumnInfo(name = CurrentTableConteins.Colums.HEAT_INDEX_F)
    val heatIndexF: Double,
    @ColumnInfo(name = CurrentTableConteins.Colums.HUMIDITY)
    val humidity: Int,
    @ColumnInfo(name = CurrentTableConteins.Colums.IS_DAY)
    val isDay: Int,
    @ColumnInfo(name = CurrentTableConteins.Colums.LAST_UPDATED)
    val lastUpdated: String,
    @ColumnInfo(name = CurrentTableConteins.Colums.LAST_UPDATED_EPOCH)
    @PrimaryKey(autoGenerate = false)
    val lastUpdatedEpoch: Long,
    @ColumnInfo(name = CurrentTableConteins.Colums.PRECIP_IN)
    val precipIn: Double,
    @ColumnInfo(name = CurrentTableConteins.Colums.PRECIP_MM)
    val precipMm: Double,
    @ColumnInfo(name = CurrentTableConteins.Colums.PRESSURE_IN)
    val pressureIn: Double,
    @ColumnInfo(name = CurrentTableConteins.Colums.PRESSURE_MB)
    val pressureMb: Double,
    @ColumnInfo(name = CurrentTableConteins.Colums.TEMP_C)
    val tempC: Double,
    @ColumnInfo(name = CurrentTableConteins.Colums.TEMP_F)
    val tempF: Double,
    @ColumnInfo(name = CurrentTableConteins.Colums.UV)
    val uv: Double,
    @ColumnInfo(name = CurrentTableConteins.Colums.VIS_KM)
    val visKm: Double,
    @ColumnInfo(name = CurrentTableConteins.Colums.VIS_MILES)
    val visMiles: Double,
    @ColumnInfo(name = CurrentTableConteins.Colums.WIND_DEGREE)
    val windDegree: Int,
    @ColumnInfo(name = CurrentTableConteins.Colums.WIND_DIR)
    val windDir: String,
    @ColumnInfo(name = CurrentTableConteins.Colums.WIND_KPH)
    val windKph: Double,
    @ColumnInfo(name = CurrentTableConteins.Colums.WIND_MPH)
    val windMph: Double,
    @ColumnInfo(name = CurrentTableConteins.Colums.WIND_CHILL_C)
    val windChillC: Double,
    @ColumnInfo(name = CurrentTableConteins.Colums.WIND_CHILL_F)
    val windChillF: Double
)