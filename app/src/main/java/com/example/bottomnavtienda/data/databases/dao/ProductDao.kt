package com.example.bottomnavtienda.data.databases.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.bottomnavtienda.data.models.Comment
import com.example.bottomnavtienda.data.models.Product

@Dao
interface ProductDao {
    @Insert
    suspend fun insertProducts(products: List<Product>)

    @Query("SELECT * FROM Product")
    suspend fun getAllProducts(): List<Product>
}