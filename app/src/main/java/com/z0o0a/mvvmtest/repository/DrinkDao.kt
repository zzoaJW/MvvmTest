package com.z0o0a.mvvmtest.repository

import androidx.lifecycle.LiveData
import androidx.room.*
import com.z0o0a.mvvmtest.model.DrinkData

@Dao
interface DrinkDao {
    @Insert
    fun insert(drinkData: DrinkData)

    @Update
    fun update(drinkData: DrinkData)

    @Delete
    fun delete(drinkData: DrinkData)

    @Query("SELECT * FROM DrinkData") // 테이블의 모든 값을 가져와라
    fun getAll(): LiveData<List<DrinkData>>
}