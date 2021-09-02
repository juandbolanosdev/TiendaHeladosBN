package com.example.bottomnavtienda.data.repositories

import com.example.bottomnavtienda.data.mocks.StoreInfoMock
import com.example.bottomnavtienda.data.models.StoreInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.sql.CommonDataSource

class HomeRepository(private val dataSource: StoreInfoMock) {

    suspend fun loadStoreInfo(): StoreInfo{
        return withContext(Dispatchers.IO){
            dataSource.loadStoreInfo()
        }
    }

}