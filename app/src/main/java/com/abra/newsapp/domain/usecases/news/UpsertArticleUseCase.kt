package com.abra.newsapp.domain.usecases.news

import com.abra.newsapp.data.local.NewsDao
import com.abra.newsapp.data.mapper.NewsArticleMapper.mapToLocalArticle
import com.abra.newsapp.domain.model.Article

class UpsertArticleUseCase(private val dao: NewsDao) {
    suspend operator fun invoke(article: Article){
        dao.upsertArticle(article.mapToLocalArticle())
    }
}