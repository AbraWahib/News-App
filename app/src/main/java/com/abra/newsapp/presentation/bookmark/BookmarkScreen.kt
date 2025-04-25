package com.abra.newsapp.presentation.bookmark

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.abra.newsapp.data.mapper.NewsArticleMapper.mapToArticle
import com.abra.newsapp.presentation.common.ArticlesList
import com.abra.newsapp.presentation.navgraph.Route
import com.abra.newsapp.util.Dimens.MediumPadding1

@Composable
fun BookmarkScreen(
    state: BookmarkState,
    navigateToDetails: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .statusBarsPadding()
            .padding(top = MediumPadding1, start = MediumPadding1, end = MediumPadding1)
    ) {

        Text(
            text = "Bookmark",
            style = MaterialTheme.typography.displayMedium.copy(fontWeight = FontWeight.Bold),
        )

        Spacer(modifier = Modifier.height(MediumPadding1))

        ArticlesList(
            articles = state.articles.map {
                it.mapToArticle()
            },
            onClick = { navigateToDetails(Route.DetailsScreen.route) }
        )
    }
}