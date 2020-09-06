package com.anureet.nestedrecyclerviewexample.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface FavouritesDetailDao{

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertData(task: Favourites): Long

}