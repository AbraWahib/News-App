package com.abra.newsapp.presentation.details

sealed class DetailsEvents {
    data object SaveArticleEvent : DetailsEvents()
    data object NavigateUpEvent : DetailsEvents()
    data object BookmarkEvent : DetailsEvents()
    data object ShareArticleEvent : DetailsEvents()
    data object BrowseEvent : DetailsEvents()

}