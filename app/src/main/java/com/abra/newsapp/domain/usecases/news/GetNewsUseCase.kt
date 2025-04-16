package com.abra.newsapp.domain.usecases.news

import com.abra.newsapp.domain.repo.NewsRepository

class GetNewsUseCase(
    private val repository: NewsRepository
) {
    operator fun invoke(sources: List<String>) = repository.getNews(sources)
}