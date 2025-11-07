package com.demox.feature.main.domain.models

data class DayData(
    val date:Long,
    val avgHumidity: Int,
    val avgTempC: Double,
    val avgVisKm: Double,
    val condition: ConditionData,
    val dailyChanceOfRain: Int,
    val dailyChanceOfSnow: Int,
    val dailyWillItRain: Int,
    val dailyWillItSnow: Int,
    val maxTempC: Double,
    val maxWindKph: Double,
    val minTempC: Double,
    val totalPrecipIn: Double,
    val totalPrecipMm: Double,
    val totalSnowCm: Double,
    val uv: Double
)
