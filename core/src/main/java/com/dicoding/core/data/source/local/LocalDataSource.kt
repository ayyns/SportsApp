package com.dicoding.core.data.source.local

import com.dicoding.core.data.source.local.entity.SportsEntity
import com.dicoding.core.data.source.local.room.SportsDao
import kotlinx.coroutines.flow.Flow

class LocalDataSource(private val sportsDao: SportsDao) {

    fun getAllTourism(): Flow<List<SportsEntity>> = sportsDao.getAllTourism()

    fun getFavoriteTourism(): Flow<List<SportsEntity>> = sportsDao.getFavoriteTourism()

    suspend fun insertTourism(tourismList: List<SportsEntity>) = sportsDao.insertTourism(tourismList)

    fun setFavoriteTourism(tourism: SportsEntity, newState: Boolean) {
        tourism.isFavorite = newState
        sportsDao.updateFavoriteTourism(tourism)
    }
}