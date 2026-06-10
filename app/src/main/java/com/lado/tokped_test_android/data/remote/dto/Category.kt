package com.lado.tokped_test_android.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class Category(
    val applinks: String = "",
    val child: List<Category> = emptyList(),
    val iconBannerURL: String = "",
    val iconImageUrl: String = "",
    val iconImageUrlGray: String = "",
    val id: String = "",
    val identifier: String = "",
    val name: String = "",
    val parentName: String = "",
    val url: String = "",
    val tree: Int? = 0
)