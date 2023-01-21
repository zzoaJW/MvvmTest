package com.z0o0a.mvvmtest.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters


@Database(entities = [DrinkTable::class], version = 1)
@TypeConverters(RoomTypeConverters::class)
abstract class DrinkTableDatabase: RoomDatabase() {
    abstract fun drinkTableDao(): DrinkTableDao

    companion object {
        private var instance: DrinkTableDatabase? = null

        @Synchronized
        fun getInstance(context: Context): DrinkTableDatabase? {
            if (instance == null) {
                synchronized(DrinkTableDatabase::class){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        DrinkTableDatabase::class.java,
                        "user-database"
                    ).build()
                }
            }
            return instance
        }
    }
}