package com.lado.tokped_test_android.domain.model

data class Category(
    val id: String,
    val name: String,
    val url: String,
    val iconImageUrl: String,
    val parentName: String,
    val child: List<Category>,
    val tree: Int?
)
