package com.z0o0a.mvvmtest.model

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface DrinkTableDao {
    @Insert
    fun insert(drink: DrinkTable)

    @Update
    fun update(drink: DrinkTable)

    @Delete
    fun delete(drink: DrinkTable)

    @Query("SELECT * FROM DrinkTable") // 테이블의 모든 값을 가져와라
    fun getAll(): List<DrinkTable>
}