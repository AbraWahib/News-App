package com.abra.newsapp.dl.module

import android.app.Application
import androidx.room.Room
import com.abra.newsapp.data.local.ArticleTypeConverter
import com.abra.newsapp.data.local.NewsDatabase
import com.abra.newsapp.util.Constants.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {
    @Provides
    @Singleton
    fun provideNewsDatabase(
        application: Application
    ): NewsDatabase {
        return Room.databaseBuilder(
            context = application,
            klass = NewsDatabase::class.java,
            name = DATABASE_NAME
        ).addTypeConverter(ArticleTypeConverter())
            .fallbackToDestructiveMigration()
            .build()
    }
    @Provides
    @Singleton
    fun provideDao(
        newsDatabase: NewsDatabase
    ) = newsDatabase.dao

}