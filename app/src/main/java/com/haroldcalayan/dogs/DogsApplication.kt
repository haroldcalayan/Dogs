package com.haroldcalayan.dogs

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class DogsApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initLogger()
    }

    private fun initLogger() {
        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())
    }

}