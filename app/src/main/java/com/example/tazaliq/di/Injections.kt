package com.example.tazaliq.di

import androidx.room.Room
import com.example.tazaliq.data.TazaliqDatabase
import com.example.tazaliq.ui.about.AboutViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import java.util.concurrent.Executor
import java.util.concurrent.Executors

val dataModule = module {
    single {
        Room.databaseBuilder(
            androidContext(),
            TazaliqDatabase::class.java,
            "TazaliqDatabase"
        ).build()
    }
    single { get<TazaliqDatabase>().aboutDao() }
}

val executorModule = module {
    single<Executor> { Executors.newSingleThreadExecutor() }
}


val viewModelModule = module {
    viewModel { AboutViewModel(get(), get()) }
}