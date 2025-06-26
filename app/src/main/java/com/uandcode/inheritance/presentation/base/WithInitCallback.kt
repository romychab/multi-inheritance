package com.uandcode.inheritance.presentation.base

interface WithInitCallback : ViewModelAddon {

    fun initialize() = with(getState()) {
        if (!isInitialized) {
            isInitialized = true
            onInitialized()
        }
    }

    fun onInitialized()

    private fun getState() = get(::AddonState)

    private class AddonState(
        var isInitialized: Boolean = false
    )

}
