package com.lado.tokped_test_android.data.remote.dto

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

@Serializable
data class CategoryX(
    val applinks: String? = "",
    val banner: JsonElement? = null,
    val child: List<CategoryX>? = emptyList(),
    val content: ContentXX? = null,
    val hidden: Int? = 0,
    val icon_banner: String? = "",
    val icon_image_url: String? = "",
    val icon_image_url_gray: String? = "",
    val id: String? = "",
    val identifier: String? = "",
    val is_adult: Int? = 0,
    val is_free_return: Boolean? = false,
    val is_intermediary: Boolean? = false,
    val is_kyc: Boolean? = false,
    val is_revamp: Boolean? = false,
    val min_age: Int? = 0,
    val name: String? = "",
    val redirection_url: String? = "",
    val rgb_color: String? = "",
    val root_category_id: Int? = 0,
    val tb_cat_id: Int? = 0,
    val tb_cat_name: String? = "",
    val template: String? = "",
    val tree: Int? = 0,
    val tts_b_side_cat_id: Int? = 0,
    val tts_b_side_cat_id_v2: Int? = 0,
    val tts_b_side_cat_name: String? = "",
    val tts_b_side_cat_name_v2: String? = "",
    val tts_sellable: Boolean? = false,
    val url: String? = "",
    val weight: Int? = 0
)