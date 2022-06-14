package com.mecheka.domain.character

import com.mecheka.data.model.character.CharacterEntity
import com.mecheka.data.repository.RickAndMortyRepository
import com.mecheka.domain.character.model.Character
import com.mecheka.domain.character.model.Location
import com.mecheka.domain.character.model.Origin
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

interface GetAllCharacterUseCase {
    operator fun invoke(): Flow<Result<List<Character>>>
}

internal class GetAllCharacterUseCaseImpl(private val repository: RickAndMortyRepository) :
    GetAllCharacterUseCase {
    override fun invoke() = repository.getAllCharacter()
        .map { data ->
            data.map { entity ->
                entity.map { it.mapToDomain() }
            }
        }
}

fun CharacterEntity.mapToDomain() = Character(created = this.created.orEmpty(),
    episode = this.episode.orEmpty(),
    gender = this.gender.orEmpty(),
    id = this.id ?: 0,
    image = this.image.orEmpty(),
    locationEntity = Location(name = this.locationEntity?.name.orEmpty(),
        url = this.locationEntity?.url.orEmpty()),
    name = this.name.orEmpty(),
    originEntity = Origin(name = this.originEntity?.name.orEmpty(),
        url = this.originEntity?.url.orEmpty()),
    species = this.species.orEmpty(),
    status = this.status.orEmpty(),
    type = this.type.orEmpty(),
    url = this.url.orEmpty()
)