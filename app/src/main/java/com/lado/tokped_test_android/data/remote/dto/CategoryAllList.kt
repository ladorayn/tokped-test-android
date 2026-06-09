package com.lado.tokped_test_android.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class CategoryAllList(
    val categories: List<Category>
)