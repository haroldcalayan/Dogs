package com.haroldcalayan.dogs.data.source.local.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.haroldcalayan.dogs.data.model.Height
import com.haroldcalayan.dogs.data.model.Weight

class WeightConverter {

    companion object {

        private val gson = Gson()

        @TypeConverter
        @JvmStatic
        fun from(model: Weight) = if(model == null) "" else gson.toJson(model)

        @TypeConverter
        @JvmStatic
        fun to(string: String) = gson.fromJson(string, Weight::class.java)

    }
}