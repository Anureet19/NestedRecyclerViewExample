package com.anureet.nestedrecyclerviewexample.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.anureet.nestedrecyclerviewexample.data.Category
import com.anureet.nestedrecyclerviewexample.data.Favourites
import com.anureet.nestedrecyclerviewexample.data.FavouritesListRepository

class FavouriteListViewModel(application: Application): AndroidViewModel(application) {
    private val repo : FavouritesListRepository = FavouritesListRepository(application)

    val items: LiveData<List<Category>>
        get() = repo.getData()

}