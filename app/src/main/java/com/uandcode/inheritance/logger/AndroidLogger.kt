package com.uandcode.inheritance.logger

import android.util.Log
import javax.inject.Inject

class AndroidLogger @Inject constructor() : Logger {

    override fun err(exception: Throwable) {
        Log.e(this::class.simpleName, "Error!", exception)
    }

    override fun log(message: String) {
        Log.d(this::class.simpleName, message)
    }

}
