package com.mecheka.domain.character.model

data class Character(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val locationEntity: Location,
    val name: String,
    val originEntity: Origin,
    val species: String,
    val status: String,
    val type: String,
    val url: String,
)