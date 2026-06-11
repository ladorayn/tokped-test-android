package com.lado.tokped_test_android.presentation.category_list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.lado.tokped_test_android.presentation.category_list.components.CategoryItem

@Composable
fun CategoryListScreen(
    navController: NavController,
    viewModel: CategoryListViewModel = hiltViewModel(),
    modifier: Modifier = Modifier
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    Box(modifier = modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(state.categories) { category ->
                CategoryItem(
                    category = category,
                    isExpanded = state.expandedCategoryIds.contains(category.id),
                    onHeaderClick = { viewModel.toggleCategory(category.id) },
                    onItemClick = { clickedCategory ->
                        // Handle action when a final leaf category is clicked
                    },
                    expandedCategoryIds = state.expandedCategoryIds,
                    onToggleCategory = { id -> viewModel.toggleCategory(id) }
                )
            }
        }
        if (state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = MaterialTheme.colorScheme.error,
                modifier = Modifier.align(Alignment.Center)
            )
        }
        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}
