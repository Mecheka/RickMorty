package com.mecheka.domain.character.model

import kotlin.random.Random

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
    var isLike: Boolean = false,
    var likeCount: Int = Random.nextInt(1,99)
)
