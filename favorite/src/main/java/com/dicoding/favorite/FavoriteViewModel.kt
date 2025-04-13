package com.dicoding.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.dicoding.core.domain.usecase.SportsUseCase

class FavoriteViewModel(sportsUseCase: SportsUseCase) : ViewModel() {
    val favoriteTourism = sportsUseCase.getFavoriteTourism().asLiveData()
}

