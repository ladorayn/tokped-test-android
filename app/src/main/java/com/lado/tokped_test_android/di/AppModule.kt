package com.lado.tokped_test_android.di

import com.lado.tokped_test_android.data.repository.MockCategoryRepositoryImpl
import com.lado.tokped_test_android.domain.repository.CategoryRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    @Singleton
    abstract fun bindCategoryRepository(
        categoryRepositoryImpl: MockCategoryRepositoryImpl
    ): CategoryRepository
}
