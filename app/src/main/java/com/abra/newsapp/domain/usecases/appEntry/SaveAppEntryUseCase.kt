package com.abra.newsapp.domain.usecases.appEntry

import com.abra.newsapp.domain.manager.LocalUserManager

class SaveAppEntryUseCase(private val localUserManager: LocalUserManager) {
    suspend operator fun invoke() {
        localUserManager.saveAppEntry()
    }
}