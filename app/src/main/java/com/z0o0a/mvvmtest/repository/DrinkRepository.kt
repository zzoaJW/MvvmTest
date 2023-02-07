package com.z0o0a.mvvmtest.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.z0o0a.mvvmtest.model.DrinkData

class DrinkRepository (application: Application) {
    private val drinkDao : DrinkDao
    private val drinkList : LiveData<List<DrinkData>>

    init {
        val drinkTableDatabase = DrinkDatabase.getInstance(application)!!
        drinkDao = drinkTableDatabase.drinkDao()
        drinkList = drinkTableDatabase.drinkDao().getAll()
    }

    fun insert(drinkData : DrinkData){
        try {
            val thread = Thread(Runnable {
                drinkDao.insert(drinkData)
            })
            thread.start()
        } catch (e : Exception){e.printStackTrace()}
    }

    fun delete(drinkData: DrinkData) {
        try {
            val thread = Thread(Runnable {
                drinkDao.delete(drinkData)
            })
            thread.start()
        } catch (e : Exception){e.printStackTrace()}
    }

    fun update(drinkData: DrinkData) {
        try {
            val thread = Thread(Runnable {
                drinkDao.update(drinkData)
            })
            thread.start()
        } catch (e : Exception){e.printStackTrace()}
    }

    fun getAll() : LiveData<List<DrinkData>> {
        return drinkList
    }
}