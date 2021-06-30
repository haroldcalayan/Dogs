package com.haroldcalayan.dogs.data.repository

import com.haroldcalayan.dogs.base.BaseRepository
import com.haroldcalayan.dogs.data.model.Breed
import com.haroldcalayan.dogs.data.model.BreedImage
import com.haroldcalayan.dogs.data.source.local.database.DogsDatabase
import com.haroldcalayan.dogs.data.source.remote.service.DogsApiService
import java.lang.Exception

interface DogsRepository {
    suspend fun getBreeds(page: Int, limit: Int): List<Breed>?
    suspend fun getImages(breedId: Int, page: Int, limit: Int): List<BreedImage>?
}

class DogsRepositoryImpl(
    private val database: DogsDatabase,
    private val api: DogsApiService
) : BaseRepository(), DogsRepository {

    override suspend fun getBreeds(page: Int, limit: Int): List<Breed>? {
        val queries = HashMap<String, String>()
        queries[PARAMS_PAGE] = page.toString()
        queries[PARAMS_LIMIT] = limit.toString()
        return try {
            val response = api.getBreeds(queries)
            database.breedDao().nukeTable()
            if (response != null) database.breedDao().insertAll(response)
            response
        } catch (ex: Exception) {
            ex.printStackTrace()
            database.breedDao().all()
        }
    }

    override suspend fun getImages(breedId: Int, page: Int, limit: Int): List<BreedImage>? {
        val queries = HashMap<String, String>()
        queries[PARAMS_BREED_ID] = breedId.toString()
        queries[PARAMS_PAGE] = page.toString()
        queries[PARAMS_LIMIT] = limit.toString()
        return try {
            val response = api.getImages(queries)
            database.breedImageDao().nukeTable()
            if (response != null) {
                response.forEach { it.breedId = breedId }
                database.breedImageDao().insertAll(response)
            }
            response
        } catch (ex: Exception) {
            ex.printStackTrace()
            database.breedImageDao().all()
        }
    }

    companion object {
        const val PARAMS_PAGE = "page"
        const val PARAMS_LIMIT = "limit"
        const val PARAMS_BREED_ID = "breed_id"
    }

}