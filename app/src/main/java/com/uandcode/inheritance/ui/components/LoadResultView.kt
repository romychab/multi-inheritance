package com.uandcode.inheritance.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.uandcode.inheritance.R
import com.uandcode.inheritance.domain.LoadResult

@Composable
fun <T> LoadResultView(
    loadResult: LoadResult<T>,
    content: @Composable (T) -> Unit,
) {
    Box {
        when (loadResult) {
            LoadResult.Loading -> {
                CircularProgressIndicator(Modifier.align(Alignment.Center))
            }
            is LoadResult.Error -> {
                Text(
                    text = stringResource(R.string.load_failed),
                    modifier = Modifier.align(Alignment.Center),
                    textAlign = TextAlign.Center,
                )
            }
            is LoadResult.Success<T> -> content(loadResult.value)
        }
    }
}
