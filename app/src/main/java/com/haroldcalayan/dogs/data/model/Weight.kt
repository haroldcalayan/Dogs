package com.haroldcalayan.dogs.data.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Weight(
    var imperial: String,
    var metric: String
)