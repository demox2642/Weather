package com.demox.core.data.database.tables.condition

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ConditionTableDao {
    @Query("DELETE FROM ${ConditionTableConteins.TABLE_NAME}")
    suspend fun clearTable()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(condition: ConditionTable)

    @Query("SELECT * " +
            "FROM ${ConditionTableConteins.TABLE_NAME} " +
            "WHERE ${ConditionTableConteins.Colums.CODE} = :code ")
    suspend fun getConditionByCode(code: Int):ConditionTable
}