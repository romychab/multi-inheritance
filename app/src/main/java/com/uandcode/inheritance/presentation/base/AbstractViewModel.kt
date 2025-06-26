package com.uandcode.inheritance.presentation.base

import androidx.lifecycle.ViewModel
import kotlin.reflect.KClass

/**
 * Abstract view-model holds states for every add-on interface.
 */
abstract class AbstractViewModel : ViewModel(), ViewModelAddon {

    private val stateMap = mutableMapOf<KClass<*>, Any>()

    override fun <T : Any> get(kClass: KClass<T>, initializer: () -> T): T {
        return stateMap.getOrPut(kClass) {
            initializer()
        } as T
    }

    override fun onCleared() {
        super.onCleared()
        stateMap.values
            .filterIsInstance<AutoCloseable>()
            .forEach(AutoCloseable::close)
        stateMap.clear()
    }

}
