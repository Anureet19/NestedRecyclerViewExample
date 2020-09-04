package com.anureet.nestedrecyclerviewexample.data

import androidx.room.ColumnInfo
import androidx.room.Relation


data class Category(
    @ColumnInfo(name = "category")
    var category: Int,

    @Relation(parentColumn = "category", entityColumn = "category", entity = Favourites::class)
    val children : List<itemName>
)