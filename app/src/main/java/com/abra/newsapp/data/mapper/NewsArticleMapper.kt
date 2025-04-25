package com.abra.newsapp.data.mapper

import com.abra.newsapp.data.local.entity.LocalArticle
import com.abra.newsapp.domain.model.Article

object NewsArticleMapper {
    fun Article.mapToLocalArticle(): LocalArticle {
        return LocalArticle(
            author = this.author,
            content = this.content,
            description = this.description,
            publishedAt = this.publishedAt,
            source = this.source,
            title = this.title,
            url = this.url,
            urlToImage = this.urlToImage
        )
    }
    fun LocalArticle.mapToArticle(): Article {
        return Article(
            author = this.author,
            content = this.content,
            description = this.description,
            publishedAt = this.publishedAt,
            source = this.source,
            title = this.title,
            url = this.url,
            urlToImage = this.urlToImage
        )
    }
    fun mapToArticlesList(localArticles: List<LocalArticle>): List<Article> {
        return localArticles.map { it.mapToArticle() }
    }

    fun mapToLocalArticlesList(articles: List<Article>): List<LocalArticle> {
        return articles.map { it.mapToLocalArticle() }
    }

}