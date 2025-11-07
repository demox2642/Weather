package com.demox.core.data.database.tables.day

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface DayTableDao {
    @Query("DELETE FROM ${DayTableConteins.TABLE_NAME}")
    suspend fun clearTable()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(dayTable: DayTable)

    @Query("SELECT * " +
            "FROM ${DayTableConteins.TABLE_NAME} ")
    suspend fun getDaysList():List<DayTable>
}