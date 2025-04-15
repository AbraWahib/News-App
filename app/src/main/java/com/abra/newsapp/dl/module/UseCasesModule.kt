package com.abra.newsapp.dl.module

import com.abra.newsapp.domain.manager.LocalUserManager
import com.abra.newsapp.domain.usecases.AppEntryUseCases
import com.abra.newsapp.domain.usecases.ReadAppEntryUseCase
import com.abra.newsapp.domain.usecases.SaveAppEntryUseCase
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
}