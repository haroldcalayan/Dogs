package com.haroldcalayan.dogs.data.source.remote.service

import com.haroldcalayan.dogs.data.model.Breed
import com.haroldcalayan.dogs.data.model.BreedImage
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface DogsApiService {

    @GET("breeds")
    suspend fun getBreeds(@QueryMap query: Map<String, String>): List<Breed>?

    @GET("images/search")
    suspend fun getImages(@QueryMap query: Map<String, String>): List<BreedImage>?

}