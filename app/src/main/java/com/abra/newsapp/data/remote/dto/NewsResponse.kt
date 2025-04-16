package com.abra.newsapp.data.remote.dto

import com.abra.newsapp.domain.model.Article

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)