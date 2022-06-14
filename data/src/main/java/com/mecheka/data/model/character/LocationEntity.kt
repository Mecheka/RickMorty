package com.mecheka.data.model.character


import com.google.gson.annotations.SerializedName

data class LocationEntity(
    @SerializedName("name")
    val name: String?,
    @SerializedName("url")
    val url: String?,
)