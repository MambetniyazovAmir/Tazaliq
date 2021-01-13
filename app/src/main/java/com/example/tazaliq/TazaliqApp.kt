package com.example.tazaliq

import android.app.Application
import com.example.tazaliq.di.dataModule
import com.example.tazaliq.di.executorModule
import com.example.tazaliq.di.firebaseModule
import com.example.tazaliq.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class TazaliqApp : Application() {

    override fun onCreate() {
        super.onCreate()
        val modules = listOf(firebaseModule, dataModule, viewModelModule, executorModule)
        startKoin {
            androidLogger()
            androidContext(this@TazaliqApp)
            androidFileProperties()
            modules(modules)
        }
    }
}