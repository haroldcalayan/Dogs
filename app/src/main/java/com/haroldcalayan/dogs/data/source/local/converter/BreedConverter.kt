package com.haroldcalayan.dogs.data.source.local.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.haroldcalayan.dogs.data.model.Breed

class BreedConverter {

    companion object {

        private val gson = Gson()

        @TypeConverter
        @JvmStatic
        fun from(model: Breed) = if(model == null) "" else gson.toJson(model)

        @TypeConverter
        @JvmStatic
        fun to(string: String) = gson.fromJson(string, Breed::class.java)

    }
}