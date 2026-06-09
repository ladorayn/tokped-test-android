package com.lado.tokped_test_android.domain.repository

import com.lado.tokped_test_android.domain.model.Category

interface CategoryRepository {
    suspend fun getCategories(): List<Category>
}