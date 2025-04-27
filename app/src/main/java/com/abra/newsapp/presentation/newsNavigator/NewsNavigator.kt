package com.abra.newsapp.presentation.newsNavigator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.paging.compose.collectAsLazyPagingItems
import com.abra.newsapp.domain.model.Article
import com.abra.newsapp.presentation.bookmark.BookmarkScreen
import com.abra.newsapp.presentation.bookmark.BookmarkVM
import com.abra.newsapp.presentation.details.DetailsScreen
import com.abra.newsapp.presentation.details.DetailsVM
import com.abra.newsapp.presentation.home.HomeScreen
import com.abra.newsapp.presentation.home.HomeVM
import com.abra.newsapp.presentation.navgraph.Route
import com.abra.newsapp.presentation.search.SearchScreen
import com.abra.newsapp.presentation.search.SearchVM

@Composable
fun NewsNavigator() {
    val bottomNavigationItems = remember {
        listOf(
            BottomNavigationItem(
                icon = Icons.Outlined.Home, text = "Home"
            ), BottomNavigationItem(
                icon = Icons.Outlined.Search, text = "Search"
            ), BottomNavigationItem(
                icon = Icons.Outlined.BookmarkBorder, text = "Bookmark"
            )
        )
    }
    val navController = rememberNavController()
    var selectedItem by rememberSaveable {
        mutableIntStateOf(0)
    }
    val backStackState = navController.currentBackStackEntryAsState().value
    selectedItem = when (backStackState?.destination?.route) {
        Route.HomeScreen.route -> 0
        Route.SearchScreen.route -> 1
        Route.BookmarkScreen.route -> 2
        else -> 0
    }
    Scaffold(
        modifier = Modifier.background(color = MaterialTheme.colorScheme.background),
        bottomBar = {
            NewsBottomNavigation(
                items = bottomNavigationItems, selectedItem = selectedItem, onItemClick = { index ->
                    when (index) {
                        0 -> navToTab(navController = navController, route = Route.HomeScreen.route)
                        1 -> navToTab(
                            navController = navController, route = Route.SearchScreen.route
                        )
                        2 -> navToTab(
                            navController = navController, route = Route.BookmarkScreen.route
                        )
                        else -> {}
                    }
                })
        }) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = Route.HomeScreen.route,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(route = Route.HomeScreen.route) {
                val viewModel: HomeVM = hiltViewModel()
                val articles = viewModel.news.collectAsLazyPagingItems()
                HomeScreen(articles = articles, navigateToSearch = {
                    navToTab(navController, Route.SearchScreen.route)
                }, navigateToDetails = { article ->
                    navToDetails(navController, article)
                })
            }
            composable(route = Route.SearchScreen.route) {
                val viewModel: SearchVM = hiltViewModel()
                SearchScreen(
                    state = viewModel.state.value,
                    event = viewModel::onEvent,
                    navigateToDetails = { article ->
                        navToDetails(navController, article = article)
                    })
            }
            composable(route = Route.DetailsScreen.route) {
                //TODO: handle side effect
                val viewModel: DetailsVM = hiltViewModel()
                navController.previousBackStackEntry?.savedStateHandle?.get<Article>("article")
                    ?.let {
                        DetailsScreen(
                            article = it,
                            navigateUp = { navController.navigateUp() },
                            event = viewModel::onEvent
                        )
                    }
            }
            composable(route = Route.BookmarkScreen.route) {
                val viewModel: BookmarkVM = hiltViewModel()
                BookmarkScreen(
                    state = viewModel.state.value,
                    navigateToDetails = { navToDetails(navController, it) })
            }
        }
    }
}

private fun navToTab(navController: NavController, route: String) {
    navController.navigate(route) {
        navController.graph.startDestinationRoute?.let { homeScreen ->
            popUpTo(homeScreen) {
                saveState = true
            }
            restoreState = true
            launchSingleTop = true
        }
    }
}

private fun navToDetails(navController: NavController, article: Article) {
    navController.currentBackStackEntry?.savedStateHandle?.set("article", article)
    navController.navigate(
        route = Route.DetailsScreen.route
    )
}