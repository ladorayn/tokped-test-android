package com.lado.tokped_test_android.presentation.category_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lado.tokped_test_android.common.Resource
import com.lado.tokped_test_android.domain.usecase.GetCategoriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class CategoryListViewModel @Inject constructor(
    private val getCategoryListUseCase: GetCategoriesUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(CategoryListState())
    val state: StateFlow<CategoryListState> = _state.asStateFlow()

    init {
        getCategories()
    }

    private fun getCategories() {
        getCategoryListUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.update {
                        it.copy(
                            isLoading = false,
                            categories = result.data ?: emptyList(),
                            error = ""
                        )
                    }
                }
                is Resource.Error -> {
                    _state.update {
                        it.copy(
                            isLoading = false,
                            error = result.message ?: "An unexpected error occurred"
                        )
                    }
                }
                is Resource.Loading -> {
                    _state.update { it.copy(isLoading = true) }
                }
            }
        }.launchIn(viewModelScope)
    }

    fun toggleCategory(categoryId: String) {
        _state.update { currentState ->
            val newIds = if (currentState.expandedCategoryIds.contains(categoryId)) {
                currentState.expandedCategoryIds - categoryId
            } else {
                currentState.expandedCategoryIds + categoryId
            }
            currentState.copy(expandedCategoryIds = newIds)
        }
    }
}