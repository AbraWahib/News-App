package com.abra.newsapp.domain.usecases.news

import com.abra.newsapp.domain.repo.NewsRepository

class SearchNewsUseCase(
    private val repository: NewsRepository
) {
    operator fun invoke(searchQuery: String, sources: List<String>) = repository.searchNews(searchQuery, sources)

}