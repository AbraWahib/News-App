package com.abra.newsapp.presentation.bookmark

import com.abra.newsapp.data.local.entity.LocalArticle

data class BookmarkState(
    val articles: List<LocalArticle> = emptyList()
)
