package com.dicoding.core.data.source.local.room

import androidx.room.*
import com.dicoding.core.data.source.local.entity.SportsEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface SportsDao {

    @Query("SELECT * FROM sports")
    fun getAllTourism(): Flow<List<SportsEntity>>

    @Query("SELECT * FROM sports where isFavorite = 1")
    fun getFavoriteTourism(): Flow<List<SportsEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTourism(tourism: List<SportsEntity>)

    @Update
    fun updateFavoriteTourism(tourism: SportsEntity)
}
