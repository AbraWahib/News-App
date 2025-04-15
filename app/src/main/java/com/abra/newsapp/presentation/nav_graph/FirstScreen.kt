package com.abra.newsapp.presentation.nav_graph

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.abra.newsapp.presentation.onboarding.OnBoardingScreen
import com.abra.newsapp.presentation.onboarding.OnBoardingVM

@Composable
fun FirstScreen(
    startDestination: String,
    modifier: Modifier = Modifier
) {
    if (startDestination == Route.OnBoardingScreen.route) {
        val vm: OnBoardingVM = hiltViewModel()
        OnBoardingScreen(modifier, vm::onEvent)
    } else {
        Box(
            modifier = modifier.fillMaxSize()
        ) {
            Text(text = "Home Screen", modifier = Modifier.align(Alignment.Center))
        }
    }
}