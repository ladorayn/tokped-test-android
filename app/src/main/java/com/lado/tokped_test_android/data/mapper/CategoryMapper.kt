package com.lado.tokped_test_android.data.mapper

import com.lado.tokped_test_android.data.remote.dto.Category as CategoryDto
import com.lado.tokped_test_android.domain.model.Category

fun CategoryDto.toDomain(): Category {
    return Category(
        id = id,
        name = name,
        url = url,
        iconImageUrl = iconImageUrl,
        parentName = parentName,
        child = child.map { it.toDomain() }
    )
}
