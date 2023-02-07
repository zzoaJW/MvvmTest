package com.z0o0a.mvvmtest.repository

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.z0o0a.mvvmtest.model.DrinkData
import com.z0o0a.mvvmtest.model.RoomTypeConverters


@Database(entities = [DrinkData::class], version = 1)
@TypeConverters(RoomTypeConverters::class)
abstract class DrinkDatabase: RoomDatabase() {
    abstract fun drinkDao(): DrinkDao

    companion object {
        private var instance: DrinkDatabase? = null

        @Synchronized
        fun getInstance(context: Context): DrinkDatabase? {
            if (instance == null) {
                synchronized(DrinkDatabase::class){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        DrinkDatabase::class.java,
                        "drink-database"
                    ).build()
                }
            }
            return instance
        }
    }
}