package com.lado.tokped_test_android.data.mapper

import com.lado.tokped_test_android.data.remote.dto.Category as CategoryDto
import com.lado.tokped_test_android.data.remote.dto.CategoryX as CategoryXDto
import com.lado.tokped_test_android.domain.model.Category

fun CategoryDto.toDomain(): Category {
    return Category(
        id = id.orEmpty(),
        name = name.orEmpty(),
        url = url.orEmpty(),
        iconImageUrl = iconImageUrl.orEmpty(),
        parentName = parentName.orEmpty(),
        child = child.map { it.toDomain() } ?: emptyList(),
        tree = tree?.or(0)
    )
}

fun CategoryXDto.toDomain(): Category {
    return Category(
        id = id.orEmpty(),
        name = name.orEmpty(),
        url = url.orEmpty(),
        iconImageUrl = icon_image_url.orEmpty(),
        parentName = "",
        child = child?.map { it.toDomain() } ?: emptyList(),
        tree = tree?.or(0),
    )
}
