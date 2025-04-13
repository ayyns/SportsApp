package com.dicoding.core.utils

import com.dicoding.core.data.source.local.entity.SportsEntity
import com.dicoding.core.data.source.remote.response.SportsResponse
import com.dicoding.core.domain.model.Sports

object DataMapper {
    fun mapResponsesToEntities(input: List<SportsResponse>): List<SportsEntity> {
        val tourismList = ArrayList<SportsEntity>()
        input.map {
            val tourism = SportsEntity(
                tourismId = it.id,
                description = it.description,
                name = it.name,
                image = it.image,
                isFavorite = false
            )
            tourismList.add(tourism)
        }
        return tourismList
    }

    fun mapEntitiesToDomain(input: List<SportsEntity>): List<Sports> =
        input.map {
            Sports(
                tourismId = it.tourismId,
                description = it.description,
                name = it.name,
                image = it.image,
                isFavorite = it.isFavorite
            )
        }

    fun mapDomainToEntity(input: Sports) = SportsEntity(
        tourismId = input.tourismId,
        description = input.description,
        name = input.name,
        image = input.image,
        isFavorite = input.isFavorite
    )
}