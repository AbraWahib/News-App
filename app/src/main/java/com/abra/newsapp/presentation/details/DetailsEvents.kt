package com.abra.newsapp.presentation.details

import com.abra.newsapp.domain.model.Article

sealed class DetailsEvents {
    data class UpsertOrDeleteArticle(val article: Article) : DetailsEvents()
    data object RemoveSideEffect : DetailsEvents()

}