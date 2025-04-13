package com.dicoding.core.data.source.remote

import android.util.Log
import com.dicoding.core.data.source.remote.network.ApiResponse
import com.dicoding.core.data.source.remote.network.ApiService
import com.dicoding.core.data.source.remote.response.SportsResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RemoteDataSource(private val apiService: ApiService) {

    suspend fun getAllSports(): Flow<ApiResponse<List<SportsResponse>>> {
        return flow {
            try {
                val response = apiService.getList()
                val dataArray = response.places

                Log.d("RemoteDataSource", "API Response: $response")

                if (!dataArray.isNullOrEmpty()) {
                    emit(ApiResponse.Success(dataArray))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", "Error fetching data", e)
            }
        }.flowOn(Dispatchers.IO)
    }
}



