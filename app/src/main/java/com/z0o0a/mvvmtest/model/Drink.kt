package com.z0o0a.mvvmtest.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DrinkTable (
    @PrimaryKey(autoGenerate = true) var id :Int,
    var drinkName: String,
    var drinkVintage: String
)

data class Drink (
    var drinkName: String,
    var drinkVintage: String
)