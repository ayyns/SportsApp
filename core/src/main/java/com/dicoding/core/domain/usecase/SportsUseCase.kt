package com.dicoding.core.domain.usecase

import com.dicoding.core.domain.model.Sports
import kotlinx.coroutines.flow.Flow

interface SportsUseCase {
    fun getAllTourism(): Flow<com.dicoding.core.data.Resource<List<Sports>>>
    fun getFavoriteTourism(): Flow<List<Sports>>
    fun setFavoriteTourism(sports: Sports, state: Boolean)
}