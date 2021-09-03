package com.example.bottomnavtienda.data.repositories

import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.example.bottomnavtienda.data.databases.dao.ProductDao
import com.example.bottomnavtienda.data.mocks.ProductMock
import com.example.bottomnavtienda.data.models.Comment
import com.example.bottomnavtienda.data.models.Product
import com.example.bottomnavtienda.utils.Constants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class ProductRepository(private val dataSource: ProductDao, private val dataSourceFirebase: FirebaseFirestore) {
    private val db: CollectionReference = dataSourceFirebase.collection(Constants.PRODUCT_COLLECTION)

    suspend fun loadProducts(): List<Product> {
//        return withContext(Dispatchers.IO) {
//            dataSource.getAllProducts()
//        }
        val snapshot = db.get().await()
        return snapshot.toObjects(Product::class.java)
    }

    suspend fun insertProducts(products: List<Product>) {
        withContext(Dispatchers.IO) {
            val temp = dataSource.getAllProducts()
            if(temp.isEmpty()) {
                dataSource.insertProducts(products)
            }
        }
    }

}