package com.lado.tokped_test_android.data.remote

import com.lado.tokped_test_android.data.remote.dto.Category
import com.lado.tokped_test_android.data.remote.dto.CategoryDtoApi
import retrofit2.http.GET

interface CategoryApi {
    @GET("category/v1/tree/all")
    suspend fun getCategories(): CategoryDtoApi

}