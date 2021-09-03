package com.example.bottomnavtienda.data.databases.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.bottomnavtienda.data.models.Comment

@Dao
interface CommentDao {
    @Insert
    suspend fun insertComments(comments: List<Comment>)

    @Query("SELECT * FROM Comment")
    suspend fun getAllComments(): List<Comment>
}