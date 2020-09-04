package com.anureet.nestedrecyclerviewexample.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface FavouritesDetailDao{
    @Query("SELECT * FROM favourites WHERE `id` = :id")
    fun getData(id: Long): LiveData<Favourites>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertData(task: Favourites): Long

    @Update
    suspend fun updateData(task: Favourites)

    @Delete
    suspend fun deleteData(task: Favourites)

}