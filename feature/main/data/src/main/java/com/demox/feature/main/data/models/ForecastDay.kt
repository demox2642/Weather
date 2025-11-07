package com.demox.feature.main.data.models

import com.google.gson.annotations.SerializedName

data class ForecastDay(
    val astro: Astro,
    val date: String,
    @SerializedName("date_epoch")
    val dateEpoch: Long,
    val day: Day,
    val hour: List<Hour>
)