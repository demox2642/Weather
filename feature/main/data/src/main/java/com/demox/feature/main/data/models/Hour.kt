package com.demox.feature.main.data.models

import com.demox.core.data.database.tables.hour.HourTable
import com.demox.feature.main.domain.models.ConditionData
import com.demox.feature.main.domain.models.HourData
import com.google.gson.annotations.SerializedName

data class Hour(
    @SerializedName("chance_of_rain")
    val chanceOfRain: Int,
    @SerializedName("chance_of_snow")
    val chanceOfSnow: Int,
    val cloud: Int,
    val condition: Condition,
    @SerializedName("dewpoint_c")
    val dewPointC: Double,
    @SerializedName("dewpoint_f")
    val dewPointF: Double,
    @SerializedName("feelslike_c")
    val feelsLikeC: Double,
    @SerializedName("feelslike_f")
    val feelsLikeF: Double,
    @SerializedName("gust_kph")
    val gustKph: Double,
    @SerializedName("gust_mph")
    val gustMph: Double,
    @SerializedName("heatindex_c")
    val heatIndexC: Double,
    @SerializedName("heatindex_f")
    val heatIndexF: Double,
    val humidity: Int,
    @SerializedName("is_day")
    val isDay: Int,
    @SerializedName("precip_in")
    val preCipIn: Double,
    @SerializedName("precip_mm")
    val preCipMm: Double,
    @SerializedName("pressure_in")
    val pressureIn: Double,
    @SerializedName("pressure_mb")
    val pressureMb: Double,
    @SerializedName("snow_cm")
    val snowCm: Double,
    @SerializedName("temp_c")
    val tempC: Double,
    @SerializedName("temp_f")
    val tempF: Double,
    val time: String,
    @SerializedName("time_epoch")
    val timeEpoch: Long,
    val uv: Double,
    @SerializedName("vis_km")
    val visKm: Double,
    @SerializedName("vis_miles")
    val visMiles: Double,
    @SerializedName("will_it_rain")
    val willItRain: Int,
    @SerializedName("will_it_snow")
    val willItSnow: Int,
    @SerializedName("wind_degree")
    val windDegree: Int,
    @SerializedName("wind_dir")
    val windDir: String,
    @SerializedName("wind_kph")
    val windKph: Double,
    @SerializedName("wind_mph")
    val windMph: Double,
    @SerializedName("windchill_c")
    val windchillC: Double,
    @SerializedName("windchill_f")
    val windchillF: Double
)

fun Hour.toHourTable() = HourTable(
    chanceOfRain = this.chanceOfRain,
    chanceOfSnow = this.chanceOfSnow,
    cloud = this.cloud,
    conditionCode = this.condition.code,
    dewPointC = this.dewPointC,
    dewPointF = this.dewPointF,
    feelsLikeC = this.feelsLikeC,
    feelsLikeF = this.feelsLikeF,
    gustKph = this.gustKph,
    gustMph = this.gustMph,
    heatIndexC = this.heatIndexC,
    heatIndexF = this.heatIndexF,
    humidity = this.humidity,
    isDay = this.isDay,
    preCipIn = this.preCipIn,
    preCipMm = this.preCipMm,
    pressureIn = this.pressureIn,
    pressureMb = this.pressureMb,
    snowCm = this.snowCm,
    tempC = this.tempC,
    tempF = this.tempF,
    time = this.time,
    timeEpoch = this.timeEpoch,
    uv = this.uv,
    visKm = this.visKm,
    visMiles = this.visMiles,
    willItRain = this.willItRain,
    willItSnow = this.willItSnow,
    windDegree = this.windDegree,
    windDir = this.windDir,
    windKph = this.windKph,
    windMph = this.windMph,
    windchillC = this.windchillC,
    windchillF = this.windchillF
)

fun HourTable.toHourData(conditionData: ConditionData) = HourData(
    chanceOfRain = this.chanceOfRain,
    chanceOfSnow = this.chanceOfSnow,
    cloud = this.cloud,
    condition = conditionData,
    dewPointC = this.dewPointC,
    feelsLikeC = this.feelsLikeC,
    gustKph = this.gustKph,
    heatIndexC = this.heatIndexC,
    humidity = this.humidity,
    isDay = this.isDay,
    preCipIn = this.preCipIn,
    preCipMm = this.preCipMm,
    pressureIn = this.pressureIn,
    pressureMb = this.pressureMb,
    snowCm = this.snowCm,
    tempC = this.tempC,
    time = this.time,
    timeEpoch = this.timeEpoch,
    uv = this.uv,
    visKm = this.visKm,
    willItRain = this.willItRain,
    willItSnow = this.willItSnow,
    windDegree = this.windDegree,
    windDir = this.windDir,
    windKph = this.windKph,
    windchillC = this.windchillC,
)