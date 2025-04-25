package com.abra.newsapp.domain.usecases.news

data class NewsUseCases(
    val getNewsUseCase: GetNewsUseCase,
    val searchNewsUseCase: SearchNewsUseCase,
    val upsertNewsArticleUseCase: UpsertNewsArticleUseCase,
    val deleteNewsArticleUseCase: DeleteNewsArticleUseCase,
    val getNewsArticlesUseCase: GetNewsArticlesUseCase
)
