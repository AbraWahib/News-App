package com.abra.newsapp.presentation.onboarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.abra.newsapp.presentation.common.FilledButton
import com.abra.newsapp.presentation.common.OutlineButton
import com.abra.newsapp.presentation.common.PageIndicator
import kotlinx.coroutines.launch

@Composable
fun OnBoardingScreen(modifier: Modifier = Modifier, onEvent: (OnBoardingEvents) -> Unit) {
    Scaffold(
        Modifier.background(color = MaterialTheme.colorScheme.background)
    ){
        Column(
            modifier = modifier.fillMaxSize().padding(it)
        ) {
            val pagerState = rememberPagerState(
                initialPage = 0
            ) {
                pages.size
            }
            val buttonState = remember {
                derivedStateOf {
                    when (pagerState.currentPage) {
                        0 -> listOf("", "Next")
                        1 -> listOf("Back", "Next")
                        2 -> listOf("Back", "Get Started")
                        else -> listOf("", "")
                    }
                }
            }
            HorizontalPager(
                state = pagerState
            ) { index ->
                OnBoardingPage(page = pages[index])
            }
            Spacer(modifier = Modifier.weight(1f))
            Row(
                modifier = Modifier.padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                PageIndicator(pageCount = pages.size, currentPage = pagerState.currentPage)
                Spacer(modifier = Modifier.weight(1f))
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    val scope = rememberCoroutineScope()
                    // back button is enabled only if the current page is not the first page
                    if (buttonState.value[0].isNotEmpty()) {
                        OutlineButton(text = buttonState.value[0]) {
                            scope.launch {
                                pagerState.animateScrollToPage(page = pagerState.currentPage - 1)
                            }
                        }
                    }
                    // next button is enabled only if the current page is not the last page
                    val isLastPage = pagerState.currentPage == pages.size - 1
                    FilledButton(
                        text = buttonState.value[1],
                        onClick = {
                            if (isLastPage) {
                                onEvent(OnBoardingEvents.SaveAppEntryEvent)
                            } else {
                                scope.launch {
                                    pagerState.animateScrollToPage(page = pagerState.currentPage + 1)
                                }
                            }
                        })

                }
            }

        }
    }
}

