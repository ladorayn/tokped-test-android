package com.lado.tokped_test_android.presentation.category_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lado.tokped_test_android.common.Resource
import com.lado.tokped_test_android.domain.usecase.GetCategoriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CategoryListViewModel @Inject constructor(
    private val getCategoryListUseCase: GetCategoriesUseCase
) : ViewModel() {

    private val _state = mutableStateOf(CategoryListState())
    val state: State<CategoryListState> = _state

    init {
        getCategories()
    }

    private fun getCategories() {
        getCategoryListUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = _state.value.copy(
                        isLoading = false,
                        categories = result.data ?: emptyList(),
                        error = ""
                    )
                }
                is Resource.Error -> {
                    _state.value = _state.value.copy(
                        isLoading = false,
                        error = result.message ?: "An unexpected error occurred"
                    )
                }
                is Resource.Loading -> {
                    _state.value = _state.value.copy(
                        isLoading = true
                    )
                }
            }
        }.launchIn(viewModelScope)
    }

    fun toggleCategory(categoryId: String) {
        val currentIds = _state.value.expandedCategoryIds
        val newIds = if (currentIds.contains(categoryId)) {
            currentIds - categoryId
        } else {
            currentIds + categoryId
        }
        _state.value = _state.value.copy(expandedCategoryIds = newIds)
    }
}