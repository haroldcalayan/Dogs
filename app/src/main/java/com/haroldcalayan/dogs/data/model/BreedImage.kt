package com.haroldcalayan.dogs.data.model

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
@Entity(tableName = "breed_image")
data class BreedImage(
    var height: Int,
    @PrimaryKey
    @Json(name = "id")
    var id: String,
    var url: String,
    var width: Int,
    var breedId: Int?
)