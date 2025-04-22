
package com.abra.newsapp.presentation.navgraph

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.abra.newsapp.presentation.onboarding.OnBoardingScreen
import com.abra.newsapp.presentation.onboarding.OnBoardingVM
import com.abra.newsapp.presentation.search.SearchScreen
import com.abra.newsapp.presentation.search.SearchVM

@Composable
fun NavGraph(
    startDestination: String,
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = startDestination) {
        navigation(
            route = Route.AppStartNavigation.route,
            startDestination = Route.OnBoardingScreen.route
        ) {
            composable(route = Route.OnBoardingScreen.route) {
                val viewModel: OnBoardingVM = hiltViewModel()
                OnBoardingScreen(onEvent = viewModel::onEvent, modifier = modifier)
            }
        }

        navigation(
            route = Route.NewsNavigation.route,
            startDestination = Route.NewsNavigatorScreen.route
        ) {
            composable(route = Route.NewsNavigatorScreen.route){
//                val viewModel:HomeVM = hiltViewModel()
//                HomeScreen(
//                    modifier = modifier,
//                    articles = viewModel.news.collectAsLazyPagingItems()
//                ) { }
                val viewModel: SearchVM = hiltViewModel()
                SearchScreen(
                    state = viewModel.state.value,
                    event = viewModel::onEvent,
                    navigate = {},
                    modifier = modifier
                )
            }
        }
    }
}
