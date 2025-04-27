package com.abra.newsapp.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.abra.newsapp.data.local.entity.LocalArticle
import kotlinx.coroutines.flow.Flow

@Dao
interface NewsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertArticle(article: LocalArticle)
    @Delete
    suspend fun deleteArticle(article: LocalArticle)
    @Query("SELECT * FROM LocalArticle")
    fun getArticles(): Flow<List<LocalArticle>>
    @Query("SELECT * FROM LocalArticle WHERE url=:url")
    suspend fun getArticleByUrl(url: String): LocalArticle?

}