package com.lado.tokped_test_android.presentation.category_list.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.unit.dp
import com.lado.tokped_test_android.domain.model.Category

@Composable
fun CategoryItem(
    category: Category,
    isExpanded: Boolean,
    onHeaderClick: () -> Unit,
    onItemClick: (Category) -> Unit,
    expandedCategoryIds: Set<String>,
    onToggleCategory: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    if (category.child.isNotEmpty()) {
                        onHeaderClick()
                    } else {
                        onItemClick(category)
                    }
                }
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = category.name,
                modifier = Modifier.weight(1f)
            )
            if (category.child.isNotEmpty()) {
                val rotationAngle by animateFloatAsState(targetValue = if (isExpanded) 180f else 0f, label = "arrowRotation")
                Icon(
                    imageVector = Icons.Default.ArrowDropDown,
                    contentDescription = if (isExpanded) "Collapse" else "Expand",
                    modifier = Modifier.rotate(rotationAngle)
                )
            }
        }

        if (isExpanded && category.child.isNotEmpty()) {
            category.tree?.let {
                if (it < 2) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 24.dp) // Indent sub-categories for tree visualization
                    ) {
                        category.child.forEach { subCategory ->
                            CategoryItem(
                                category = subCategory,
                                isExpanded = expandedCategoryIds.contains(subCategory.id),
                                onHeaderClick = { onToggleCategory(subCategory.id) },
                                onItemClick = onItemClick,
                                expandedCategoryIds = expandedCategoryIds,
                                onToggleCategory = onToggleCategory
                            )
                        }
                    }
                } else {
                    LazyRow(
                        modifier = Modifier.fillMaxWidth().padding(start = 24.dp)
                    ) {
                        items(category.child) { subCategory ->
                            CategoryRowItem(
                                category = subCategory,
                                onItemClick = onItemClick,
                            )
                        }
                    }
                }
            }

        }
    }
}
