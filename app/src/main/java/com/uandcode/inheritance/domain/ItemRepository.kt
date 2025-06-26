package com.uandcode.inheritance.domain

interface ItemRepository {
    suspend fun getItems(): List<Item>
}
