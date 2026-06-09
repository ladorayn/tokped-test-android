package com.lado.tokped_test_android.domain.usecase

import com.lado.tokped_test_android.common.Resource
import com.lado.tokped_test_android.domain.model.Category
import com.lado.tokped_test_android.domain.repository.CategoryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetCategoriesUseCase @Inject constructor(
    private val repository: CategoryRepository
) {
    operator fun invoke(): Flow<Resource<List<Category>>> = flow {
        try {
            emit(Resource.Loading())
            val categories = repository.getCategories()
            emit(Resource.Success(categories))
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        }
    }
}