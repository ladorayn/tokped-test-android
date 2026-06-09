package com.lado.tokped_test_android.presentation.category_list

import com.lado.tokped_test_android.domain.model.Category

data class CategoryListState(
    val isLoading: Boolean = false,
    val categories: List<Category> = emptyList(),
    val expandedCategoryIds: Set<String> = emptySet(),
    val error: String = "",
)
