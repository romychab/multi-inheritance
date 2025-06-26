package com.uandcode.inheritance.presentation.base

import com.uandcode.inheritance.logger.Logger
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel

interface WithCustomViewModelScope : ViewModelAddon {

    val viewModelScope: CoroutineScope
        get() = getState().scope

    private fun getState() = get(::createState)

    private fun createState(): AddonState {
        val exceptionHandler = CoroutineExceptionHandler { _, exception ->
            Logger.err(exception)
        }
        val scope = CoroutineScope(
            Dispatchers.Main.immediate + SupervisorJob() + exceptionHandler
        )
        return AddonState(scope)
    }

    private class AddonState(
        val scope: CoroutineScope
    ) : AutoCloseable {
        override fun close() {
            scope.cancel()
        }
    }

}
