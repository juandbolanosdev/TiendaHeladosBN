package com.example.bottomnavtienda.data.repositories

import com.example.bottomnavtienda.data.mocks.CommentMock
import com.example.bottomnavtienda.data.models.Comment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.sql.CommonDataSource

class CommentRepository(private val dataSource: CommentMock) {
    suspend fun loadComment():List<Comment>{
        return withContext(Dispatchers.IO){
            dataSource.loadComments()
        }
    }
}