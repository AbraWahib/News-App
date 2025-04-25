package com.abra.newsapp.domain.usecases.news

import com.abra.newsapp.data.local.NewsDao
import com.abra.newsapp.data.local.entity.LocalArticle

class DeleteNewsArticleUseCase(private val dao: NewsDao) {
    suspend operator fun invoke(article: LocalArticle) {
        dao.deleteArticle(article)
    }

}