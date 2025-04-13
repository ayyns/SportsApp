package com.dicoding.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ListSportsResponse(

    @field:SerializedName("teams")
    val places: List<SportsResponse>? = null
)