package com.abra.newsapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abra.newsapp.domain.usecases.AppEntryUseCases
import com.abra.newsapp.presentation.nav_graph.Route
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainVM @Inject constructor(useCases: AppEntryUseCases) : ViewModel() {

    var splashCondition by mutableStateOf(true)
        private set
    var startDestination by mutableStateOf(Route.OnBoardingScreen.route)
        private set

    init {
        viewModelScope.launch {
            useCases.readAppEntryUseCase().collect { isItNotFirstTime ->
                startDestination =
                    if (isItNotFirstTime) Route.HomeScreen.route else Route.OnBoardingScreen.route
                delay(200)
                splashCondition = false
            }
        }

    }
}