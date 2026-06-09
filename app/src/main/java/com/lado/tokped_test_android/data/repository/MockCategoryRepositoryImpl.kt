package com.lado.tokped_test_android.data.repository

import com.lado.tokped_test_android.common.Constants
import com.lado.tokped_test_android.data.mapper.toDomain
import com.lado.tokped_test_android.data.remote.dto.CategoryList
import com.lado.tokped_test_android.domain.model.Category
import com.lado.tokped_test_android.domain.repository.CategoryRepository
import javax.inject.Inject
import kotlinx.serialization.json.Json

class MockCategoryRepositoryImpl @Inject constructor() : CategoryRepository {
    override suspend fun getCategories(): List<Category> {
        val parsedResponse = Json.decodeFromString<CategoryList>(Constants.MOCK_RESPONSE)
        return parsedResponse.data.categoryAllList.categories.map { it.toDomain() }
    }
}
