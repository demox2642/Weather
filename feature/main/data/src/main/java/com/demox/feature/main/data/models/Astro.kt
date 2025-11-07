package com.demox.feature.main.data.models

import com.demox.core.data.database.tables.astro.AstroTable
import com.demox.feature.main.domain.models.AstroData
import com.google.gson.annotations.SerializedName

data class Astro(
    @SerializedName("is_moon_up")
    val isMoonUp: Int,
    @SerializedName("is_sun_up")
    val isSunUp: Int,
    @SerializedName("moon_illumination")
    val moonIllumination: Int,
    @SerializedName("moon_phase")
    val moonPhase: String,
    val moonrise: String,
    val moonset: String,
    val sunrise: String,
    val sunset: String
)

fun Astro.toAstroTable(dateEpoch: Long) = AstroTable(
    dateEpoch = dateEpoch,
    isMoonUp = this.isMoonUp,
    isSunUp = this.isSunUp,
    moonIllumination = this.moonIllumination,
    moonPhase = this.moonPhase,
    moonrise = this.moonrise,
    moonset = this.moonset,
    sunrise = this.sunrise,
    sunset = this.sunset,
)

fun AstroTable.toAstroData()= AstroData(
    dateEpoch = this.dateEpoch,
    isMoonUp = this.isMoonUp,
    isSunUp = this.isSunUp,
    moonIllumination = this.moonIllumination,
    moonPhase = this.moonPhase,
    moonrise = this.moonrise,
    moonset = this.moonset,
    sunrise = this.sunrise,
    sunset = this.sunset
)