package com.haroldcalayan.dogs.data.source.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.haroldcalayan.dogs.base.BaseDao
import com.haroldcalayan.dogs.data.model.BreedImage

@Dao
interface BreedImageDao : BaseDao<BreedImage> {

    @Query("SELECT * FROM $TABLE_NAME")
    suspend fun all(): List<BreedImage>?

    @Query("SELECT * FROM $TABLE_NAME WHERE id = :id")
    suspend fun get(id: String): BreedImage?

    @Query("SELECT * FROM $TABLE_NAME WHERE breedId = :breedId")
    suspend fun getByBreedId(breedId: String): List<BreedImage>?

    @Query("SELECT * FROM $TABLE_NAME LIMIT 1")
    suspend fun getFirst(): BreedImage?

    @Query("DELETE FROM $TABLE_NAME")
    suspend fun nukeTable()

    companion object {
        const val TABLE_NAME = "breed_image"
    }

}