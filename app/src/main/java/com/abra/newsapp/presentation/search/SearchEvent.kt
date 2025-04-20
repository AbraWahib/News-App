package com.abra.newsapp.presentation.search

sealed class SearchEvent {
    data class updateSearchQuery(val searchQuery: String) : SearchEvent()
    object searchNews : SearchEvent()

}