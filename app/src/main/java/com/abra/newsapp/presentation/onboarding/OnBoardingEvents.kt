package com.abra.newsapp.presentation.onboarding

sealed class OnBoardingEvents {
    data object SaveAppEntryEvent: OnBoardingEvents()
}