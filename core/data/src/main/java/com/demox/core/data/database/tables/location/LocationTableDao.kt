package com.demox.core.data.database.tables.location

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface LocationTableDao {
    @Query("DELETE FROM ${LocationTableConteins.TABLE_NAME}")
    suspend fun clearTable()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(locationTable: LocationTable)

    @Query("SELECT * " +
            "FROM ${LocationTableConteins.TABLE_NAME} " +
            "LIMIT 1 ")
    suspend fun getLocation(): LocationTable
}