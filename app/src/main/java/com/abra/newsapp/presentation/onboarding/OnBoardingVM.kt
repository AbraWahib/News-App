package com.abra.newsapp.presentation.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abra.newsapp.domain.usecases.AppEntryUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnBoardingVM @Inject constructor(
   private val appEntryUseCases: AppEntryUseCases
): ViewModel() {
    fun onEvent(event: OnBoardingEvents){
        when(event){
            is OnBoardingEvents.SaveAppEntryEvent ->{
                viewModelScope.launch {
                    appEntryUseCases.saveAppEntryUseCase()
                }
            }
        }
    }
}