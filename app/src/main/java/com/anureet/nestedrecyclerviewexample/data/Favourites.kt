package com.anureet.nestedrecyclerviewexample.data

import androidx.room.Entity
import androidx.room.PrimaryKey

enum class Categories{
    Movies, Sports, Fruits, Vegetables
}

@Entity(tableName = "favourites")
data class Favourites(@PrimaryKey(autoGenerate = true) val id: Long,
                      val name : String,
                      val category: Int)