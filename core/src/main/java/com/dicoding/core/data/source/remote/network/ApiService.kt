package com.dicoding.core.data.source.remote.network

import com.dicoding.core.data.source.remote.response.ListSportsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("search_all_teams.php?l=English%20Premier%20League")
    suspend fun getList(): ListSportsResponse
}
