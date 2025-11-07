package com.demox.core.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.demox.core.data.database.tables.astro.AstroTable
import com.demox.core.data.database.tables.astro.AstroTableDao
import com.demox.core.data.database.tables.condition.ConditionTable
import com.demox.core.data.database.tables.condition.ConditionTableDao
import com.demox.core.data.database.tables.current.CurrentTable
import com.demox.core.data.database.tables.current.CurrentTableDao
import com.demox.core.data.database.tables.day.DayTable
import com.demox.core.data.database.tables.day.DayTableDao
import com.demox.core.data.database.tables.hour.HourTable
import com.demox.core.data.database.tables.hour.HourTableDao
import com.demox.core.data.database.tables.location.LocationTable
import com.demox.core.data.database.tables.location.LocationTableDao

@Database(
    entities = [
        AstroTable::class,
        ConditionTable::class,
        CurrentTable::class,
        DayTable::class,
        HourTable::class,
        LocationTable::class
               ],
    version = 1,
    exportSchema = false
)
abstract class WeatherDataBase: RoomDatabase()  {
    abstract fun getAstroTableDao(): AstroTableDao
    abstract fun getConditionTableDao(): ConditionTableDao
    abstract fun getCurrentTableDao(): CurrentTableDao
    abstract fun getDayTableDao(): DayTableDao
    abstract fun getHourTableDao(): HourTableDao
    abstract fun getLocationTableDao(): LocationTableDao
}