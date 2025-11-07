package com.demox.core.data.database.tables.location

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = LocationTableConteins.TABLE_NAME)
data class LocationTable(
    @ColumnInfo(name = LocationTableConteins.Colums.COUNTRY)
    val country: String,
    @ColumnInfo(name = LocationTableConteins.Colums.LAT)
    val lat: Double,
    @ColumnInfo(name = LocationTableConteins.Colums.LOCAL_TIME)
    val localtime: String,
    @ColumnInfo(name = LocationTableConteins.Colums.LOCAL_TIME_EPOCH)
    val localtimeEpoch: Int,
    @ColumnInfo(name = LocationTableConteins.Colums.LON)
    val lon: Double,
    @ColumnInfo(name = LocationTableConteins.Colums.NAME)
    val name: String,
    @ColumnInfo(name = LocationTableConteins.Colums.REGION)
    val region: String,
    @ColumnInfo(name = LocationTableConteins.Colums.TZ_ID)
    @PrimaryKey(autoGenerate = false)
    val tzId: String
)
