package com.abra.newsapp.presentation.details

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abra.newsapp.domain.model.Article
import com.abra.newsapp.domain.usecases.news.NewsUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsVM @Inject constructor(
    private val newsUseCases: NewsUseCases
) : ViewModel() {
    var sideEffect by mutableStateOf<String?>(null)
        private set

    fun onEvent(event: DetailsEvents) {
        when (event) {
            is DetailsEvents.UpsertOrDeleteArticle -> {
                viewModelScope.launch {
                    val article = newsUseCases.selectArticleByUrlUseCase(event.article.url)
                    if (article == null) {
                        upsertArticle(event.article)
                    } else {
                        deleteArticle(event.article)
                    }
                }
            }

            DetailsEvents.RemoveSideEffect -> sideEffect = null
        }
    }

    private suspend fun deleteArticle(article: Article) {
        newsUseCases.deleteNewsArticleUseCase(article)
        sideEffect = "Article Deleted"
    }

    private suspend fun upsertArticle(article: Article) {
        newsUseCases.upsertArticleUseCase(article)
        sideEffect = "Article Saved"
    }
}