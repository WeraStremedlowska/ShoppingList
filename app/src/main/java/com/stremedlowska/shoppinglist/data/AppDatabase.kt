package com.stremedlowska.shoppinglist.data

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ShopItemDbModel::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    
    abstract fun shopListDao(): ShopListDao
    
    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null
        private val LOCK = Any()
        private const val DB_NAME = "shop_item.db"
        
        fun getInstance(application: Application): AppDatabase {
            return INSTANCE ?: synchronized(LOCK) {
                INSTANCE ?: Room.databaseBuilder(
                    application,
                    AppDatabase::class.java,
                    DB_NAME
                ).build().also { INSTANCE = it }
            }
        }
    }
}