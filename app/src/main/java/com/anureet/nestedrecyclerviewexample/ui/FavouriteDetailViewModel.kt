package com.anureet.nestedrecyclerviewexample.ui

import android.app.Application
import androidx.lifecycle.*
import com.anureet.nestedrecyclerviewexample.data.Favourites
import com.anureet.nestedrecyclerviewexample.data.FavouritesDetailRepository
import kotlinx.coroutines.launch

class FavouriteDetailViewModel(application: Application): AndroidViewModel(application) {
    private val repo: FavouritesDetailRepository = FavouritesDetailRepository(application)


    fun saveTask(data: Favourites){
        viewModelScope.launch {
                repo.insertTask(data)
        }
    }
}