package com.uandcode.inheritance.logger

interface Logger {

    fun err(exception: Throwable)

    fun log(message: String)

    companion object : Logger {
        private var instance: Logger = EmptyLogger

        override fun err(exception: Throwable) {
            instance.err(exception)
        }

        override fun log(message: String) {
            instance.log(message)
        }

        fun set(logger: Logger) {
            this.instance = logger
        }
    }
}
