package com.abra.newsapp.domain.usecases.news

import com.abra.newsapp.data.local.NewsDao
import com.abra.newsapp.data.local.entity.LocalArticle

class UpsertNewsArticleUseCase(private val dao: NewsDao) {
    suspend operator fun invoke(article: LocalArticle){
        dao.upsertArticle(article)
    }
}