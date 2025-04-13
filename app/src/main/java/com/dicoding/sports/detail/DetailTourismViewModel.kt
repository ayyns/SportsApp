package com.dicoding.sports.detail

import androidx.lifecycle.ViewModel
import com.dicoding.core.domain.model.Sports
import com.dicoding.core.domain.usecase.SportsUseCase

class DetailTourismViewModel(private val sportsUseCase: SportsUseCase) : ViewModel() {
    fun setFavoriteTourism(sports: Sports, newStatus:Boolean) =
        sportsUseCase.setFavoriteTourism(sports, newStatus)
}

