package com.z0o0a.mvvmtest.model

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class DrinkTableRepository (application: Application) {

    private val drinkTableDatabase = DrinkTableDatabase.getInstance(application)!!
    private val drinkTableDao : DrinkTableDao = drinkTableDatabase.drinkTableDao()
    private val drinkTable : MutableLiveData<List<DrinkTable>>? = null

    init {
        drinkTable!!.value = drinkTableDao.getAll()
    }

    fun getAll() : LiveData<List<DrinkTable>> {
        return drinkTable!!
    }

    fun insert(drinkTable : DrinkTable){
        try {
            val thread = Thread(Runnable {
                drinkTableDao.insert(drinkTable)
            })
            thread.start()
        } catch (e : Exception){e.printStackTrace()}
    }

    fun delete(drinkTable: DrinkTable) {
        try {
            val thread = Thread(Runnable {
                drinkTableDao.delete(drinkTable)
            })
            thread.start()
        } catch (e : Exception){e.printStackTrace()}

    }
    fun update(drinkTable: DrinkTable) {
        try {
            val thread = Thread(Runnable {
                drinkTableDao.update(drinkTable)
            })
            thread.start()
        } catch (e : Exception){e.printStackTrace()}

    }
}