package com.danzucker.alarmel

import android.app.Application
import com.danzucker.alarmel.alarm.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class AlarmelApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@AlarmelApplication)
            androidLogger()

            modules(appModule)
        }
    }
}