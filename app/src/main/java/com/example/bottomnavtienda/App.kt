package com.example.bottomnavtienda

import android.app.Application
import com.example.bottomnavtienda.di.dataSourceModule
import com.example.bottomnavtienda.di.databaseModule
import com.example.bottomnavtienda.di.repoModule
import com.example.bottomnavtienda.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App:Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(listOf(dataSourceModule, repoModule, databaseModule, viewModelModule))
        }
    }
}