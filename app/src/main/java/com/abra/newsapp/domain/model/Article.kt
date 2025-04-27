package com.abra.newsapp.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
@Parcelize
data class Article(
    val author: String = "",
    val content: String = "",
    val description: String = "",
    val publishedAt: String = "",
    val source: Source = Source("", ""),
    val title: String = "",
    val url: String = "",
    val urlToImage: String = ""
) : Parcelable