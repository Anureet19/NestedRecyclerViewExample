package com.anureet.nestedrecyclerviewexample.data

import android.app.Application
import androidx.lifecycle.LiveData

class FavouritesListRepository(context:Application) {
    private val favouritesListDao: FavouritesListDao = FavouritesDatabase.getDatabase(context).favouritesListDao()

    fun getData(): LiveData<List<Category>> {
        return favouritesListDao.getData()
    }

}