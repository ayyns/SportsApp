package com.dicoding.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class  Sports(
    val tourismId: Int,
    val name: String,
    val description: String,
    val image: String?,
    val isFavorite: Boolean
) : Parcelable