package com.haroldcalayan.dogs.data.source.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.haroldcalayan.dogs.data.model.Breed
import com.haroldcalayan.dogs.data.model.BreedImage
import com.haroldcalayan.dogs.data.source.local.converter.HeightConverter
import com.haroldcalayan.dogs.data.source.local.converter.ImageConverter
import com.haroldcalayan.dogs.data.source.local.converter.WeightConverter
import com.haroldcalayan.dogs.data.source.local.dao.BreedDao
import com.haroldcalayan.dogs.data.source.local.dao.BreedImageDao

const val VERSION_NUMBER = 2

@Database(
    entities = [Breed::class, BreedImage::class],
    version = VERSION_NUMBER
)
@TypeConverters(HeightConverter::class, ImageConverter::class, WeightConverter::class)
abstract class DogsDatabase : RoomDatabase() {
    abstract fun breedDao(): BreedDao
    abstract fun breedImageDao(): BreedImageDao
}