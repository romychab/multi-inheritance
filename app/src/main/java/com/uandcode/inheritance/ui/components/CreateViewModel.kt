package com.uandcode.inheritance.ui.components

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import com.uandcode.inheritance.presentation.base.WithInitCallback

@Composable
inline fun <reified VM : ViewModel> createViewModel(): VM {
    return hiltViewModel<VM>().also { viewModel ->
        (viewModel as? WithInitCallback)?.initialize()
    }
}
