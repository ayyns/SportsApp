package com.dicoding.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class SportsResponse(
    @field:SerializedName("idTeam")
    val id: Int,

    @field:SerializedName("strTeam")
    val name: String,

    @field:SerializedName("strDescriptionEN")
    val description: String,

    @field:SerializedName("strBadge")
    val image: String?
)

