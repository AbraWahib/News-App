package com.abra.newsapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.abra.newsapp.data.local.entity.LocalArticle

@Database(entities = [LocalArticle::class], version = 1, exportSchema = false)
@TypeConverters(ArticleTypeConverter::class)
abstract class NewsDatabase: RoomDatabase() {
    abstract val dao: NewsDao
}