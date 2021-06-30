package com.haroldcalayan.dogs.di

import android.content.Context
import androidx.room.Room
import com.haroldcalayan.dogs.BuildConfig
import com.haroldcalayan.dogs.data.source.local.database.DogsDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): DogsDatabase {
        return Room.databaseBuilder(
            appContext,
            DogsDatabase::class.java,
            BuildConfig.DATABASE_NAME
        ).build()
    }

    @Provides
    fun provideBreedDao(database: DogsDatabase) = database.breedDao()

    @Provides
    fun provideBreedImageDao(database: DogsDatabase) = database.breedImageDao()

}