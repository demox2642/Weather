package com.demox.feature.main.data.models

import com.demox.core.data.database.tables.day.DayTable
import com.demox.feature.main.domain.models.ConditionData
import com.demox.feature.main.domain.models.DayData
import com.google.gson.annotations.SerializedName

data class Day(
    @SerializedName("avghumidity")
    val avgHumidity: Int,
    @SerializedName("avgtemp_c")
    val avgTempC: Double,
    @SerializedName("avgtemp_f")
    val avgTempF: Double,
    @SerializedName("avgvis_km")
    val avgVisKm: Double,
    @SerializedName("avgvis_miles")
    val avgVisMiles: Double,
    val condition: Condition,
    @SerializedName("daily_chance_of_rain")
    val dailyChanceOfRain: Int,
    @SerializedName("daily_chance_of_snow")
    val dailyChanceOfSnow: Int,
    @SerializedName("daily_will_it_rain")
    val dailyWillItRain: Int,
    @SerializedName("daily_will_it_snow")
    val dailyWillItSnow: Int,
    @SerializedName("maxtemp_c")
    val maxTempC: Double,
    @SerializedName("maxtemp_f")
    val maxTempF: Double,
    @SerializedName("maxwind_kph")
    val maxWindKph: Double,
    @SerializedName("maxwind_mph")
    val maxWindMph: Double,
    @SerializedName("mintemp_c")
    val minTempC: Double,
    @SerializedName("mintemp_f")
    val minTempF: Double,
    @SerializedName("totalprecip_in")
    val totalPrecipIn: Double,
    @SerializedName("totalprecip_mm")
    val totalPrecipMm: Double,
    @SerializedName("totalsnow_cm")
    val totalSnowCm: Double,
    val uv: Double
)

fun Day.toDayTable(dateEpoch: Long)= DayTable(
    dateEpoch = dateEpoch,
    avgHumidity = this.avgHumidity,
    avgTempC = this.avgTempC,
    avgTempF = this.avgTempF,
    avgVisKm = this.avgVisKm,
    avgVisMiles = this.avgVisMiles,
    conditionCode = this.condition.code,
    dailyChanceOfRain = this.dailyChanceOfRain,
    dailyChanceOfSnow = this.dailyChanceOfSnow,
    dailyWillItRain = this.dailyWillItRain,
    dailyWillItSnow = this.dailyWillItSnow,
    maxTempC = this.maxTempC,
    maxTempF = this.maxTempF,
    maxWindKph = this.maxWindKph,
    maxWindMph = this.maxWindMph,
    minTempC = this.minTempC,
    minTempF = this.minTempF,
    totalPrecipIn = this.totalPrecipIn,
    totalPrecipMm = this.totalPrecipMm,
    totalSnowCm = this.totalSnowCm,
    uv = this.uv
)

fun DayTable.toDayData(conditionData: ConditionData) = DayData(
    date = this.dateEpoch,
    avgHumidity = this.avgHumidity,
    avgTempC = this.avgTempC,
    avgVisKm = this.avgVisKm,
    condition = conditionData,
    dailyChanceOfRain = this.dailyChanceOfRain,
    dailyChanceOfSnow = this.dailyChanceOfSnow,
    dailyWillItRain = this.dailyWillItRain,
    dailyWillItSnow = this.dailyWillItSnow,
    maxTempC = this.maxTempC,
    maxWindKph = this.maxWindKph,
    minTempC = this.minTempC,
    totalPrecipIn = this.totalPrecipIn,
    totalPrecipMm = this.totalPrecipMm,
    totalSnowCm = this.totalSnowCm,
    uv = this.uv
)