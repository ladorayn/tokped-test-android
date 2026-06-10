package com.lado.tokped_test_android.di

import com.lado.tokped_test_android.common.Constants
import com.lado.tokped_test_android.data.remote.CategoryApi
import com.lado.tokped_test_android.data.repository.CategoryRepositoryImpl
import com.lado.tokped_test_android.data.repository.MockCategoryRepositoryImpl
import com.lado.tokped_test_android.domain.repository.CategoryRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    @Singleton
    abstract fun bindCategoryRepository(
        impl: CategoryRepositoryImpl
    ): CategoryRepository

    companion object {
        @Provides
        @Singleton
        fun provideCategoryApi(): CategoryApi {
            return Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(CategoryApi::class.java)
        }
    }
}
