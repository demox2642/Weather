package com.demox.core.data.database.tables.astro

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = AstroTableConteins.TABLE_NAME,
    indices = [Index(AstroTableConteins.Colums.DATE_EPOCH)],
)
data class AstroTable (
    @ColumnInfo(name = AstroTableConteins.Colums.DATE_EPOCH)
    @PrimaryKey(autoGenerate = false)
    val dateEpoch: Long,
    @ColumnInfo(name = AstroTableConteins.Colums.IS_MOON_UP)
    val isMoonUp: Int,
    @ColumnInfo(name = AstroTableConteins.Colums.IS_SUN_UP)
    val isSunUp: Int,
    @ColumnInfo(name = AstroTableConteins.Colums.MOON_ILLUMINATION)
    val moonIllumination: Int,
    @ColumnInfo(name = AstroTableConteins.Colums.MOON_PHASE)
    val moonPhase: String,
    @ColumnInfo(name = AstroTableConteins.Colums.MOON_RISE)
    val moonrise: String,
    @ColumnInfo(name = AstroTableConteins.Colums.MOON_SET)
    val moonset: String,
    @ColumnInfo(name = AstroTableConteins.Colums.SUN_RISE)
    val sunrise: String,
    @ColumnInfo(name = AstroTableConteins.Colums.SUN_SET)
    val sunset: String
)