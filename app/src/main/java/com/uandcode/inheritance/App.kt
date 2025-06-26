package com.uandcode.inheritance

import android.app.Application
import com.uandcode.inheritance.logger.Logger
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class App : Application() {

    @Inject
    lateinit var logger: Logger

    override fun onCreate() {
        super.onCreate()
        Logger.set(logger)
    }

}
