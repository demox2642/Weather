package com.demox.core.data.database.tables.condition

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.demox.core.data.database.tables.astro.AstroTableConteins

@Entity(tableName = ConditionTableConteins.TABLE_NAME,
    indices = [Index(ConditionTableConteins.Colums.CODE)],
)
data class ConditionTable(
    @ColumnInfo(name = ConditionTableConteins.Colums.CODE)
    @PrimaryKey(autoGenerate = false)
    val code: Int,
    @ColumnInfo(name = ConditionTableConteins.Colums.ICON)
    val icon: String,
    @ColumnInfo(name = ConditionTableConteins.Colums.TEXT)
    val text: String
)
