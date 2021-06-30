package com.haroldcalayan.dogs.data.source.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.haroldcalayan.dogs.base.BaseDao
import com.haroldcalayan.dogs.data.model.Breed

@Dao
interface BreedDao : BaseDao<Breed> {

    @Query("SELECT * FROM $TABLE_NAME")
    suspend fun all(): List<Breed>?

    @Query("SELECT * FROM $TABLE_NAME WHERE id = :id")
    suspend fun get(id: Int): Breed?

    @Query("SELECT * FROM $TABLE_NAME ORDER BY id DESC LIMIT 1")
    suspend fun getFirst(): Breed?

    @Query("DELETE FROM $TABLE_NAME")
    suspend fun nukeTable()

    companion object {
        const val TABLE_NAME = "breed"
    }

}