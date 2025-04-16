package com.abra.newsapp.dl.module

import com.abra.newsapp.data.remote.ApiService
import com.abra.newsapp.data.repo.NewsRepositoryImpl
import com.abra.newsapp.domain.repo.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {

    @Provides
    @Singleton
    fun provideNewsRepository(apiService: ApiService): NewsRepository =
        NewsRepositoryImpl(apiService)
}