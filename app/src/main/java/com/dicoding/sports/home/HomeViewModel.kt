package com.dicoding.sports.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.dicoding.core.domain.usecase.SportsUseCase

class HomeViewModel(sportsUseCase: SportsUseCase) : ViewModel() {
    val tourism = sportsUseCase.getAllTourism().asLiveData()
}

