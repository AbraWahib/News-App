package com.abra.newsapp.presentation.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.compose.collectAsLazyPagingItems
import com.abra.newsapp.presentation.common.ArticlesList
import com.abra.newsapp.presentation.common.SearchBar
import com.abra.newsapp.presentation.navgraph.Route
import com.abra.newsapp.util.Dimens

@Composable
fun SearchScreen(
    state: SearchState,
    event: (SearchEvent) -> Unit,
    navigate: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .statusBarsPadding()
            .padding(horizontal = Dimens.MediumPadding1)
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
    ) {

        SearchBar(
            text = state.searchQuery,
            readOnly = false,
            onValueChange = { event(SearchEvent.UpdateSearchQuery(it)) },
            onSearch = { event(SearchEvent.SearchNews) })
        Spacer(Modifier.height(4.dp))
        state.articles?.let {
            val artists = it.collectAsLazyPagingItems()
            ArticlesList(articles = artists, onClick = {navigate(Route.DetailsScreen.route)})
        }
    }
}