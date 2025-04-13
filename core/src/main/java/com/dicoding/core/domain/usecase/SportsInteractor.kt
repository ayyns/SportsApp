package com.dicoding.core.domain.usecase

import com.dicoding.core.domain.model.Sports
import com.dicoding.core.domain.repository.ISportsRepository

class SportsInteractor(private val tourismRepository: ISportsRepository): SportsUseCase {

    override fun getAllTourism() = tourismRepository.getAllTourism()

    override fun getFavoriteTourism() = tourismRepository.getFavoriteTourism()

    override fun setFavoriteTourism(sports: Sports, state: Boolean) = tourismRepository.setFavoriteTourism(sports, state)
}