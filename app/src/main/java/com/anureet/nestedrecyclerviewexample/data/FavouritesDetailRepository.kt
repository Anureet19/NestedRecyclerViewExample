package com.anureet.nestedrecyclerviewexample.data

import android.app.Application
import androidx.lifecycle.LiveData

class FavouritesDetailRepository(context: Application) {
    private val favouritesDetailDao : FavouritesDetailDao = FavouritesDatabase.getDatabase(context).favouritesDetailDao()

    suspend fun insertTask(item: Favourites): Long {
        return favouritesDetailDao.insertData(item)
    }

}