package com.lado.tokped_test_android.data.remote

import com.lado.tokped_test_android.data.remote.dto.Category
import retrofit2.http.GET

interface CategoryApi {
    @GET("categories")
    suspend fun getCategories(): List<Category>

}