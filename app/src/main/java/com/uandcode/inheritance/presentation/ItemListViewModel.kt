package com.uandcode.inheritance.presentation

import androidx.compose.runtime.Immutable
import com.uandcode.inheritance.domain.Item
import com.uandcode.inheritance.domain.ItemRepository
import com.uandcode.inheritance.logger.Logger
import com.uandcode.inheritance.presentation.base.AbstractViewModel
import com.uandcode.inheritance.presentation.base.WithCustomViewModelScope
import com.uandcode.inheritance.presentation.base.WithInitCallback
import com.uandcode.inheritance.presentation.base.WithStateLoader
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import javax.inject.Inject

@HiltViewModel
class ItemListViewModel @Inject constructor(
    private val itemRepository: ItemRepository,
) : AbstractViewModel(),
    WithInitCallback,
    WithCustomViewModelScope,
    WithStateLoader<ItemListViewModel.ScreenState> {

    override fun onInitialized() {
        Logger.log("Example of init callback")
    }

    override suspend fun load(): ScreenState {
        return ScreenState(itemRepository.getItems().toImmutableList())
    }

    @Immutable
    data class ScreenState(
        val items: ImmutableList<Item>
    )

}
