package com.uandcode.inheritance.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.uandcode.inheritance.domain.Item
import com.uandcode.inheritance.presentation.ItemListViewModel.ScreenState
import com.uandcode.inheritance.ui.components.LoadResultView
import com.uandcode.inheritance.ui.components.createViewModel

@Composable
fun ItemListScreen() {
    val viewModel = createViewModel<ItemListViewModel>()
    val loadResult by viewModel.stateFlow.collectAsState()
    LoadResultView(
        loadResult = loadResult,
    ) { state ->
        ItemListContent(state)
    }
}

@Composable
fun ItemListContent(
    screenState: ScreenState,
) {
    LazyColumn {
        items(screenState.items) { item ->
            ItemView(item)
        }
    }
}

@Composable
fun ItemView(item: Item) {
    Column(
        modifier = Modifier.fillMaxWidth().padding(8.dp),
    ) {
        Text(
            text = item.title,
            modifier = Modifier.fillMaxWidth(),
            style = MaterialTheme.typography.titleMedium,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1,
        )
        Text(
            text = item.description,
            style = MaterialTheme.typography.bodyMedium,
            overflow = TextOverflow.Ellipsis,
            maxLines = 2,
        )
    }
}
