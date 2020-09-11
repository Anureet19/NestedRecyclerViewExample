package com.anureet.nestedrecyclerviewexample.data
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Favourites::class], version = 1)
abstract class FavouritesDatabase : RoomDatabase() {
    abstract fun favouritesListDao(): FavouritesListDao
    abstract fun favouritesDetailDao(): FavouritesDetailDao

    companion object {
        @Volatile
        private var instance: FavouritesDatabase? = null

        fun getDatabase(context: Context) = instance
            ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    FavouritesDatabase::class.java,
                    "favourite_database"
                ).build().also { instance = it }
            }
    }
}