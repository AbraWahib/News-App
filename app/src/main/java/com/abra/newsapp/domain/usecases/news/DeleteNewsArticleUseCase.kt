package com.abra.newsapp.domain.usecases.news

import com.abra.newsapp.data.local.NewsDao
import com.abra.newsapp.data.local.entity.LocalArticle
import com.abra.newsapp.data.mapper.NewsArticleMapper.mapToLocalArticle
import com.abra.newsapp.domain.model.Article

class DeleteNewsArticleUseCase(private val dao: NewsDao) {
    suspend operator fun invoke(article: Article) {
        dao.deleteArticle(article.mapToLocalArticle())
    }

}