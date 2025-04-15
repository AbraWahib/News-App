package com.abra.newsapp.presentation.nav_graph

sealed class Route(val route: String) {
    object OnBoardingScreen : Route("onBoardingScreen")
    object HomeScreen : Route("homeScreen")
    object SearchScreen : Route("searchScreen")
    object BookmarkScreen : Route("bookmarkScreen")
    object DetailsScreen : Route("detailsScreen")
}