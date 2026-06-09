package com.lado.tokped_test_android.data.repository

import com.lado.tokped_test_android.data.mapper.toDomain
import com.lado.tokped_test_android.data.remote.CategoryApi
import com.lado.tokped_test_android.domain.model.Category
import com.lado.tokped_test_android.domain.repository.CategoryRepository
import javax.inject.Inject

class CategoryRepositoryImpl @Inject constructor(
    private val api: CategoryApi
) : CategoryRepository {
    override suspend fun getCategories(): List<Category> {
        // Live API integration mapping Category DTO to Domain models
        return api.getCategories().map { it.toDomain() }
    }
}