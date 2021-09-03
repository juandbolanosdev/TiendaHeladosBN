package com.example.bottomnavtienda.data.repositories

import com.example.bottomnavtienda.data.databases.dao.CommentDao
import com.example.bottomnavtienda.data.mocks.CommentMock
import com.example.bottomnavtienda.data.models.Comment
import com.example.bottomnavtienda.utils.Constants
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import javax.sql.CommonDataSource

class CommentRepository(private val dataSource: CommentDao, private val dataSourceFirebase: FirebaseFirestore) {
    private val db: CollectionReference = dataSourceFirebase.collection(Constants.COMMENT_COLLECTION)

    suspend fun loadComments(): List<Comment> {
//        return withContext(Dispatchers.IO) {
//            dataSource.getAllComments()
//        }
        val snapshot = db.get().await()
        return snapshot.toObjects(Comment::class.java)
    }

    suspend fun insertComments(comments: List<Comment>) {
        withContext(Dispatchers.IO) {
            val temp = dataSource.getAllComments()
            if(temp.isEmpty()) {
                dataSource.insertComments(comments)
            }
        }

    }

}