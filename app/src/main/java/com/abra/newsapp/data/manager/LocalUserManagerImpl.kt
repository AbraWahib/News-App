package com.abra.newsapp.data.manager

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.abra.newsapp.domain.manager.LocalUserManager
import com.abra.newsapp.util.Constants.APP_ENTRY
import com.abra.newsapp.util.Constants.USER_SETTINGS
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class LocalUserManagerImpl(
    private val context: Context
) : LocalUserManager {
    override suspend fun saveAppEntry() {
        context.dataStore.edit { settings ->
            settings[PreferencesKeys.appEntryKey] = true
        }
    }

    override fun getDataEntry(): Flow<Boolean> = context.dataStore.data.map {
        it[PreferencesKeys.appEntryKey] ?: false
    }
}

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = USER_SETTINGS)

private object PreferencesKeys {
    val appEntryKey = booleanPreferencesKey(name = APP_ENTRY)
}