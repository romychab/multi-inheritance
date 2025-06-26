package com.uandcode.inheritance.di

import com.uandcode.inheritance.logger.AndroidLogger
import com.uandcode.inheritance.logger.Logger
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface LoggerModule {

    @Binds
    fun bindLogger(
        impl: AndroidLogger
    ): Logger

}
