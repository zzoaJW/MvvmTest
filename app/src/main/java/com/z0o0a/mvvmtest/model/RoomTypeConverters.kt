package com.z0o0a.mvvmtest.model

import androidx.room.TypeConverter
import com.google.gson.Gson

class RoomTypeConverters {
    @TypeConverter
    fun arrayToStr(value: List<String>?): String? {
        return Gson().toJson(value)
    }

    @TypeConverter
    fun strToArray(value: String?): List<String>? {
        return Gson().fromJson(value,Array<String>::class.java)?.toList()
    }
}