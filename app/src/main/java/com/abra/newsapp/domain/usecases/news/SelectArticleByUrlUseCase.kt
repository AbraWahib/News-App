package com.abra.newsapp.domain.usecases.news

import com.abra.newsapp.data.local.NewsDao
import com.abra.newsapp.data.mapper.NewsArticleMapper.mapToArticle
import com.abra.newsapp.domain.model.Article

class SelectArticleByUrlUseCase(private val dao: NewsDao) {
    suspend operator fun invoke(url: String): Article?{
        return dao.getArticleByUrl(url)?.mapToArticle()
    }
}