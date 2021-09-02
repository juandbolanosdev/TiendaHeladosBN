package com.example.bottomnavtienda.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bottomnavtienda.data.models.Comment
import com.example.bottomnavtienda.data.repositories.CommentRepository
import kotlinx.coroutines.launch

class CommentViewModel(private val repo: CommentRepository):ViewModel() {
    private var _comments: MutableLiveData<List<Comment>> = MutableLiveData()
    val comments: LiveData<List<Comment>> get() = comments
    fun loadComments(){
        viewModelScope.launch {
            _comments.postValue(repo.loadComment())
        }
    }
}