package com.uandcode.inheritance.di

import com.uandcode.inheritance.data.ItemRepositoryImpl
import com.uandcode.inheritance.domain.ItemRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoriesModule {

    @Binds
    fun bindItemsRepository(
        impl: ItemRepositoryImpl
    ): ItemRepository

}
