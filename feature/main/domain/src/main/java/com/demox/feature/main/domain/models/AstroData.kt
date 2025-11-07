package com.demox.feature.main.domain.models

data class AstroData(
    val dateEpoch: Long,
    val isMoonUp: Int,
    val isSunUp: Int,
    val moonIllumination: Int,
    val moonPhase: String,
    val moonrise: String,
    val moonset: String,
    val sunrise: String,
    val sunset: String
)
