package com.example.bottomnavtienda.data.repositories

import com.example.bottomnavtienda.data.mocks.ProductMock
import com.example.bottomnavtienda.data.models.Product
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ProductRepository(private val dataSource: ProductMock){
    suspend fun loadProducts():List<Product>{
        return withContext(Dispatchers.IO){
            dataSource.loadProducts()
        }
    }

}