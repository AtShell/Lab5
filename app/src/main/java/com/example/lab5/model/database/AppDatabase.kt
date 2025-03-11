package com.example.lab5.model.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.lab5.model.database.entities.DifficultyLevelsDbEntity
import com.example.lab5.model.database.entities.ResultsDbEntity
import com.example.lab5.model.database.entities.StatisticDbEntity

@Database(
    version = 1,
    entities = [
        DifficultyLevelsDbEntity::class,
        ResultsDbEntity::class,
        StatisticDbEntity::class
    ]
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getStatisticDao(): StatisticDao

}