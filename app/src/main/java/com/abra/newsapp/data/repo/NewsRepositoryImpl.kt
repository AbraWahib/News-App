package com.abra.newsapp.data.repo

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.abra.newsapp.data.remote.ApiService
import com.abra.newsapp.data.remote.NewsPagingSource
import com.abra.newsapp.data.remote.SearchNewsPagingSource
import com.abra.newsapp.domain.model.Article
import com.abra.newsapp.domain.repo.NewsRepository
import kotlinx.coroutines.flow.Flow

class NewsRepositoryImpl(
    private val apiService: ApiService
) : NewsRepository {
    override fun getNews(sources: List<String>): Flow<PagingData<Article>> = Pager(
        config = PagingConfig(pageSize = 10),
        pagingSourceFactory = {
            NewsPagingSource(
                apiService = apiService,
                sources = sources.joinToString(",")
            )
        }
    ).flow

    override fun searchNews(searchQuery: String, sources: List<String>): Flow<PagingData<Article>>  = Pager(
        config = PagingConfig(pageSize = 10),
        pagingSourceFactory = {
            SearchNewsPagingSource(
                searchQuery = searchQuery,
                apiService = apiService,
                sources = sources.joinToString(",")
            )
        }
    ).flow
}