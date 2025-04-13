package com.dicoding.core.data

import com.dicoding.core.data.source.local.LocalDataSource
import com.dicoding.core.data.source.remote.RemoteDataSource
import com.dicoding.core.data.source.remote.network.ApiResponse
import com.dicoding.core.data.source.remote.response.SportsResponse
import com.dicoding.core.domain.model.Sports
import com.dicoding.core.domain.repository.ISportsRepository
import com.dicoding.core.utils.AppExecutors
import com.dicoding.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class SportsRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : ISportsRepository {

    override fun getAllTourism(): Flow<Resource<List<Sports>>> =
        object : NetworkBoundResource<List<Sports>, List<SportsResponse>>() {
            override fun loadFromDB(): Flow<List<Sports>> {
                return localDataSource.getAllTourism().map {
                    DataMapper.mapEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<Sports>?): Boolean =
                data.isNullOrEmpty()

            override suspend fun createCall(): Flow<ApiResponse<List<SportsResponse>>> =
                remoteDataSource.getAllSports()

            override suspend fun saveCallResult(data: List<SportsResponse>) {
                val tourismList = DataMapper.mapResponsesToEntities(data)
                localDataSource.insertTourism(tourismList)
            }
        }.asFlow()

    override fun getFavoriteTourism(): Flow<List<Sports>> {
        return localDataSource.getFavoriteTourism().map {
           DataMapper.mapEntitiesToDomain(it)
        }
    }

    override fun setFavoriteTourism(sports: Sports, state: Boolean) {
        val tourismEntity = DataMapper.mapDomainToEntity(sports)
        appExecutors.diskIO().execute { localDataSource.setFavoriteTourism(tourismEntity, state) }
    }
}

