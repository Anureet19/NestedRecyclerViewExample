package com.anureet.nestedrecyclerviewexample.data

import androidx.room.ColumnInfo

data class itemName(
    @ColumnInfo(name = "name")
    val name: String
)
