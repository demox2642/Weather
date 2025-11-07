package com.demox.feature.main.data.models

import com.demox.core.data.database.tables.location.LocationTable
import com.demox.feature.main.domain.models.LocationData
import com.google.gson.annotations.SerializedName

data class Location(
    val country: String,
    val lat: Double,
    val localtime: String,
    @SerializedName("localtime_epoch")
    val localtimeEpoch: Int,
    val lon: Double,
    val name: String,
    val region: String,
    @SerializedName("tz_id")
    val tzId: String
)

fun Location.toLocationTable() = LocationTable(
    country = this.country,
    lat = this.lat,
    localtime = this.localtime,
    localtimeEpoch = this.localtimeEpoch,
    lon = this.lon,
    name = this.name,
    region = this.region,
    tzId = this.tzId
)

fun LocationTable.toLocationData() = LocationData(
    name = this.name,
    country = this.country,
)