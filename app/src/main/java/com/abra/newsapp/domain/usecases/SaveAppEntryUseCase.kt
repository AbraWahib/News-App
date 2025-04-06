package com.abra.newsapp.domain.usecases

import com.abra.newsapp.domain.manager.LocalUserManager

class SaveAppEntryUseCase(private val localUserManager: LocalUserManager) {
    suspend operator fun invoke() {
        localUserManager.saveAppEntry()
    }
}