package com.haroldcalayan.dogs.di

import com.haroldcalayan.dogs.data.repository.DogsRepository
import com.haroldcalayan.dogs.data.repository.DogsRepositoryImpl
import com.haroldcalayan.dogs.data.source.local.database.DogsDatabase
import com.haroldcalayan.dogs.data.source.remote.service.DogsApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideDogsRepository(database: DogsDatabase, api: DogsApiService): DogsRepository {
        return DogsRepositoryImpl(database, api)
    }
}