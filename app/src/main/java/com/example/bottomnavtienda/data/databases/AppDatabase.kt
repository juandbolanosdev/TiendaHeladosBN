package com.example.bottomnavtienda.data.databases

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.bottomnavtienda.data.databases.dao.CommentDao
import com.example.bottomnavtienda.data.databases.dao.ProductDao
import com.example.bottomnavtienda.data.databases.dao.StoreDao
import com.example.bottomnavtienda.data.models.Comment
import com.example.bottomnavtienda.data.models.Product
import com.example.bottomnavtienda.data.models.StoreInfo

@Database(entities = [Comment::class, Product::class, StoreInfo::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun commentDao(): CommentDao
    abstract fun productDao(): ProductDao
    abstract fun storeDao(): StoreDao

    companion object {
        @Volatile
        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            if(instance == null) {
                synchronized(this) {
                    instance = Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "exaample.db")
                        .build()
                }
            }
            return instance!!
        }
    }

}