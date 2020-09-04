package com.anureet.nestedrecyclerviewexample.data

import android.app.Application
import androidx.lifecycle.LiveData

class FavouritesDetailRepository(context: Application) {
    private val favouritesDetailDao : FavouritesDetailDao = FavouritesDatabase.getDatabase(context).favouritesDetailDao()

    fun getTask(id: Long): LiveData<Favourites> {
        return favouritesDetailDao.getData(id)
    }

    suspend fun insertTask(item: Favourites): Long{
        return favouritesDetailDao.insertData(item)
    }
    suspend fun updateTask(item: Favourites){
        favouritesDetailDao.updateData(item)
    }
    suspend fun deleteTask(item: Favourites){
        favouritesDetailDao.deleteData(item)
    }


}