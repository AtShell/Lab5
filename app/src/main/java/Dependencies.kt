package com.example.lab5

import android.content.Context
import androidx.room.Room
import com.example.lab5.model.StatisticRepository
import com.example.lab5.model.database.AppDatabase

object Dependencies {

    private lateinit var applicationContext: Context

    fun init(context: Context) {
        applicationContext = context
    }

    private val appDatabase: AppDatabase by lazy {
        Room.databaseBuilder(applicationContext, AppDatabase::class.java, "database.db")
            .createFromAsset("room_article.db")
            .build()
    }

    val statisticRepository: StatisticRepository by lazy { StatisticRepository(appDatabase.getStatisticDao()) }
}