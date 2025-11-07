package com.demox.core.data.database.tables.current

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CurrentTableDao {
    @Query("DELETE FROM ${CurrentTableConteins.TABLE_NAME}")
    suspend fun clearTable()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(currentTable: CurrentTable)

    @Query("SELECT * " +
            "FROM ${CurrentTableConteins.TABLE_NAME} " +
            "LIMIT 1")
    suspend fun getCurrentTable():CurrentTable
}