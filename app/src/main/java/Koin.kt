package com.example.lab5
import com.example.lab5.model.StatisticRepository
import com.example.lab5.model.database.AppDatabase
import com.example.lab5.screens.main.MainViewModel
import com.example.lab5.screens.statistic.AllStatisticViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { AppDatabase.getInstance(get()) }
    single { get<AppDatabase>().getStatisticDao() }
    single { StatisticRepository(get()) }
    viewModel { AllStatisticViewModel(get()) }
    viewModel { MainViewModel(get()) }
}