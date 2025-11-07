package com.demox.core.data.database.tables.hour

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface HourTableDao {
    @Query("DELETE FROM ${HourTableConteins.TABLE_NAME}")
    suspend fun clearTable()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(hourTableList: List<HourTable>)

    @Query("SELECT * " +
            "FROM ${HourTableConteins.TABLE_NAME} ")
    suspend fun getHourList():List<HourTable>
}