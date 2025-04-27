package com.abra.newsapp.domain.usecases.news

import com.abra.newsapp.data.local.NewsDao
import com.abra.newsapp.data.local.entity.LocalArticle
import kotlinx.coroutines.flow.Flow

class GetArticlesUseCase(private val dao: NewsDao) {
    operator fun invoke(): Flow<List<LocalArticle>> {
        return dao.getArticles()
    }

}