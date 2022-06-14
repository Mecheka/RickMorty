package com.mecheka.data.model

import com.google.gson.annotations.SerializedName

open class BaseResponse<out T> {
    @SerializedName("info")
    val info: Info? = null

    @SerializedName("results")
    val results: T? = null
}
