package com.uandcode.inheritance.presentation.base

import kotlin.reflect.KClass

/**
 * Interfaces derived from [ViewModelAddon] can have a state.
 *
 * Use [get] method to create and get any state holder in your interface.
 */
interface ViewModelAddon {
    fun <T : Any> get(kClass: KClass<T>, initializer: () -> T): T
}

inline fun <reified T : Any> ViewModelAddon.get(
    noinline initializer: () -> T,
): T {
    return get(T::class, initializer)
}
