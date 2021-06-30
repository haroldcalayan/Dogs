package com.haroldcalayan.dogs.data.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Image(
    var height: Int,
    var id: String,
    var url: String,
    var width: Int
)