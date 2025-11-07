package com.demox.feature.main.data.models

import com.demox.core.data.database.tables.current.CurrentTable
import com.demox.feature.main.domain.models.ConditionData
import com.demox.feature.main.domain.models.CurrentData
import com.google.gson.annotations.SerializedName

data class Current(
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
    @SerializedName("last_updated")
    val lastUpdated: String,
    @SerializedName("last_updated_epoch")
    val lastUpdatedEpoch: Long,
    @SerializedName("precip_in")
    val precipIn: Double,
    @SerializedName("precip_mm")
    val precipMm: Double,
    @SerializedName("pressure_in")
    val pressureIn: Double,
    @SerializedName("pressure_mb")
    val pressureMb: Double,
    @SerializedName("temp_c")
    val tempC: Double,
    @SerializedName("temp_f")
    val tempF: Double,
    val uv: Double,
    @SerializedName("vis_km")
    val visKm: Double,
    @SerializedName("vis_miles")
    val visMiles: Double,
    @SerializedName("wind_degree")
    val windDegree: Int,
    @SerializedName("wind_dir")
    val windDir: String,
    @SerializedName("wind_kph")
    val windKph: Double,
    @SerializedName("wind_mph")
    val windMph: Double,
    @SerializedName("windchill_c")
    val windChillC: Double,
    @SerializedName("windchill_f")
    val windChillF: Double
)

fun Current.toCurrentTable()= CurrentTable(
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
    lastUpdated = this.lastUpdated,
    lastUpdatedEpoch = this.lastUpdatedEpoch,
    precipIn = this.precipIn,
    precipMm = this.precipMm,
    pressureIn = this.pressureIn,
    pressureMb = this.pressureMb,
    tempC = this.tempC,
    tempF = this.tempF,
    uv = this.uv,
    visKm = this.visKm,
    visMiles = this.visMiles,
    windDegree = this.windDegree,
    windDir = this.windDir,
    windKph = this.windKph,
    windMph = this.windMph,
    windChillC = this.windChillC,
    windChillF = this.windChillF
)

fun CurrentTable.toCurrentData(conditionData: ConditionData) = CurrentData(
    cloud = this.cloud,
    condition =conditionData,
    dewPointC =this.dewPointC,
    feelsLikeC =this.feelsLikeC,
    gustKph =this.gustKph,
    heatIndexC =this.heatIndexC,
    humidity =this.humidity,
    isDay =this.isDay,
    lastUpdated =this.lastUpdated,
    lastUpdatedEpoch =this.lastUpdatedEpoch,
    precipIn =this.precipIn,
    precipMm =this.precipMm,
    pressureIn =this.pressureIn,
    pressureMb =this.pressureMb,
    tempC =this.tempC,
    uv =this.uv,
    visKm =this.visKm,
    windDegree =this.windDegree,
    windDir =this.windDir,
    windKph =this.windKph,
    windChillC =this.windChillC
)