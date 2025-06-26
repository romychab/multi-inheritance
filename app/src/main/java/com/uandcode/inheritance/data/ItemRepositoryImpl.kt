package com.uandcode.inheritance.data

import com.github.javafaker.Faker
import com.uandcode.inheritance.domain.Item
import com.uandcode.inheritance.domain.ItemRepository
import kotlinx.coroutines.delay
import java.util.Random
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ItemRepositoryImpl @Inject constructor() : ItemRepository {

    private val faker = Faker.instance(Random(1))
    private var items = buildFakeList()

    override suspend fun getItems(): List<Item> {
        delay(2000)
        return items.toList()
    }

    private fun buildFakeList() = List(60) {
        val id = it + 1L
        ItemImpl(
            id = id,
            title = faker.book().title(),
            description = faker.lorem().sentence(10, 10)
        )
    }

    private data class ItemImpl(
        override val id: Long,
        override val title: String,
        override val description: String,
    ) : Item

}
