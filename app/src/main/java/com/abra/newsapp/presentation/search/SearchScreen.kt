package com.abra.newsapp.presentation.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
        modifier = modifier.statusBarsPadding()
    ) {

        SearchBar(
            text = state.searchQuery,
            readOnly = false,
            onValueChange = { event(SearchEvent.updateSearchQuery(it)) },
            onSearch = { event(SearchEvent.searchNews) })
        Spacer(modifier.height(Dimens.MediumPadding1))
        state.articles?.let {
            val artists = it.collectAsLazyPagingItems()
            ArticlesList(articles = artists, onClick = {navigate(Route.DetailsScreen.route)})
        }
    }
}