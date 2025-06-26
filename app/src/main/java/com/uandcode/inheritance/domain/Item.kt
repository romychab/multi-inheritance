package com.uandcode.inheritance.domain

import androidx.compose.runtime.Immutable

@Immutable
interface Item {
    val id: Long
    val title: String
    val description: String
}
