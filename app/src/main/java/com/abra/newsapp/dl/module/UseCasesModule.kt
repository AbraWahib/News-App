package com.abra.newsapp.dl.module

import com.abra.newsapp.domain.manager.LocalUserManager
import com.abra.newsapp.domain.repo.NewsRepository
import com.abra.newsapp.domain.usecases.appEntry.AppEntryUseCases
import com.abra.newsapp.domain.usecases.appEntry.ReadAppEntryUseCase
import com.abra.newsapp.domain.usecases.appEntry.SaveAppEntryUseCase
import com.abra.newsapp.domain.usecases.news.GetNewsUseCase
import com.abra.newsapp.domain.usecases.news.NewsUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCasesModule {
    @Provides
    @Singleton
    fun provideAppEntryUseCases(
        localUserManager: LocalUserManager
    ) = AppEntryUseCases(
        readAppEntryUseCase = ReadAppEntryUseCase(localUserManager),
        saveAppEntryUseCase = SaveAppEntryUseCase(localUserManager)
    )

    @Provides
    @Singleton
    fun provideNewsUseCases(
        newsRepository: NewsRepository
    ):NewsUseCases = NewsUseCases(
        getNewsUseCase = GetNewsUseCase(newsRepository)
    )
}