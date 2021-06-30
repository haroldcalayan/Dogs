package com.haroldcalayan.dogs.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
@Entity(tableName = "breed")
data class Breed(
    @Json(name = "bred_for")
    var bredFor: String?,
    @Json(name = "breed_group")
    var breedGroup: String?,
    var height: Height?,
    @PrimaryKey
    var id: Int,
    var image: Image?,
    @Json(name = "life_span")
    var lifeSpan: String?,
    var name: String?,
    var origin: String?,
    @Json(name = "reference_image_id")
    var referenceImageId: String?,
    var temperament: String?,
    var weight: Weight?
)