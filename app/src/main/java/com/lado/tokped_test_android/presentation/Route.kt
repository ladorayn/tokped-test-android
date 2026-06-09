package com.lado.tokped_test_android.presentation

sealed class Route(val route: String) {
    object categoryListScreen: Route("category_list_screen")
}