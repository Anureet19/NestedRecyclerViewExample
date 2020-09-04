package com.anureet.nestedrecyclerviewexample.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query

@Dao
interface FavouritesListDao{
    @Query("SELECT f1.category, (SELECT f2.name FROM favourites as f2 WHERE f1.category = f2.category) FROM favourites as f1 GROUP BY category")
    fun getData(): LiveData<List<Category>>

}