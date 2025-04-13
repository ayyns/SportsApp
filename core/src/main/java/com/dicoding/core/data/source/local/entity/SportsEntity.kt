package com.dicoding.core.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sports")
data class SportsEntity(
    @PrimaryKey
    val tourismId: Int,

    @ColumnInfo(name = "strTeam")
    val name: String,

    @ColumnInfo(name = "strDescriptionEN")
    val description: String,

    @ColumnInfo(name = "strBadge")
    val image: String?,

    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean = false
)
