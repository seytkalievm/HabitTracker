package com.example.habittracker

import android.app.Application
import timber.log.Timber


class HabitTrackerApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}