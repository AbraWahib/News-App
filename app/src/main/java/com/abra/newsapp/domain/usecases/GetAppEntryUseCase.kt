package com.abra.newsapp.domain.usecases

import com.abra.newsapp.domain.manager.LocalUserManager
import kotlinx.coroutines.flow.Flow

class GetAppEntryUseCase(
    private val localUserManager: LocalUserManager
) {
    operator fun invoke(): Flow<Boolean> = localUserManager.getDataEntry()
}