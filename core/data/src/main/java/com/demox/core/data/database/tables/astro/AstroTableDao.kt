package com.demox.core.data.database.tables.astro

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface AstroTableDao {

    @Query("DELETE FROM ${AstroTableConteins.TABLE_NAME}")
    suspend fun clearTable()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(astro: AstroTable)

    @Query("SELECT * " +
            "FROM ${AstroTableConteins.TABLE_NAME} ")
    suspend fun getAstroList():List<AstroTable>
}