package com.abra.newsapp.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.abra.newsapp.domain.model.Source

@Entity
data class LocalArticle(
    val author: String = "",
    val content: String = "",
    val description: String = "",
    val publishedAt: String = "",
    val source: Source = Source("", ""),
    val title: String = "",
    @PrimaryKey val url: String = "",
    val urlToImage: String = ""
)
