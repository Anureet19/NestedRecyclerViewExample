package com.anureet.nestedrecyclerviewexample.ui

import android.app.Application
import androidx.lifecycle.*
import com.anureet.nestedrecyclerviewexample.data.Favourites
import com.anureet.nestedrecyclerviewexample.data.FavouritesDetailRepository
import kotlinx.coroutines.launch

class FavouriteDetailViewModel(application: Application): AndroidViewModel(application) {
    private val repo: FavouritesDetailRepository = FavouritesDetailRepository(application)
    private val _itemId = MutableLiveData<Long>(0)

    val itemId: LiveData<Long>
        get() = _itemId

    val item: LiveData<Favourites> = Transformations.switchMap(_itemId){ id ->
        repo.getTask(id)
    }

    fun setTaskId(id: Long){
        if(_itemId.value != id){
            _itemId.value = id
        }
    }

    fun saveTask(data: Favourites){
        viewModelScope.launch {
            if(_itemId.value == 0L){
                _itemId.value = repo.insertTask(data)
            }else{
                repo.updateTask(data)
            }
        }
    }

    fun deleteTask(){
        viewModelScope.launch {
            item.value?.let{
                repo.deleteTask(it)
            }
        }
    }

}