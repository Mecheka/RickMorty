package com.mecheka.domain.location

import com.mecheka.data.model.character.LocationEntity
import com.mecheka.data.repository.RickAndMortyRepository
import com.mecheka.domain.character.model.Location
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

interface GetAllLocationUseCase {
    operator fun invoke(): Flow<Result<List<Location>>>
}

class GetAllLocationUseCaseImpl @Inject constructor(private val repository: RickAndMortyRepository) :
    GetAllLocationUseCase {
    override fun invoke() = repository.getAllLocation()
        .map { result ->
            result.map { location ->
                location.map { it.mapToDomain() }
            }
        }
}

internal fun LocationEntity.mapToDomain() = Location(
    created = this.created.orEmpty(),
    dimension = this.dimension.orEmpty(),
    id = this.id ?: 0,
    name = this.name.orEmpty(),
    residents = this.residents.orEmpty(),
    type = this.type.orEmpty(),
    url = this.url.orEmpty()
)
