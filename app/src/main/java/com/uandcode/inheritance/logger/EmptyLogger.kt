package com.uandcode.inheritance.logger

object EmptyLogger : Logger {
    override fun err(exception: Throwable) = Unit
    override fun log(message: String) = Unit
}
