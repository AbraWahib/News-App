package com.abra.newsapp.domain.usecases.news

data class NewsUseCases(
    val getNewsUseCase: GetNewsUseCase,
    val searchNewsUseCase: SearchNewsUseCase,
    val upsertArticleUseCase: UpsertArticleUseCase,
    val deleteNewsArticleUseCase: DeleteNewsArticleUseCase,
    val getNewsArticlesUseCase: GetArticlesUseCase,
    val selectArticleByUrlUseCase: SelectArticleByUrlUseCase
)
