package com.uandcode.inheritance.domain

import androidx.compose.runtime.Immutable

@Immutable
sealed class LoadResult<out T> {
    data object Loading : LoadResult<Nothing>()
    data class Success<T>(val value: T) : LoadResult<T>()
    data class Error(val exception: Exception) : LoadResult<Nothing>()
}
