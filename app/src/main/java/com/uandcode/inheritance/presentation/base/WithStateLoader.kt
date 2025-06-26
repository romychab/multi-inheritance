package com.uandcode.inheritance.presentation.base

import com.uandcode.inheritance.domain.LoadResult
import kotlinx.coroutines.ensureActive
import kotlinx.coroutines.flow.SharingStarted.Companion.WhileSubscribed
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import kotlin.coroutines.coroutineContext

interface WithStateLoader<T> : ViewModelAddon, WithCustomViewModelScope {

    val stateFlow: StateFlow<LoadResult<T>>
        get() = getState().stateFlow

    suspend fun load(): T

    private fun getState() = get(::createState)

    private fun createState(): AddonState<T> {
        val stateFlow = flow {
            try {
                emit(LoadResult.Success(load()))
            } catch (e: Exception) {
                coroutineContext.ensureActive()
                emit(LoadResult.Error(e))
            }
        }.stateIn(viewModelScope, WhileSubscribed(1000), LoadResult.Loading)
        return AddonState(stateFlow)
    }

    private class AddonState<T>(
        val stateFlow: StateFlow<LoadResult<T>>,
    )

}
