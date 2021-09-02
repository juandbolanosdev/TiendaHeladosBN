package com.example.bottomnavtienda.data.mocks

import com.example.bottomnavtienda.data.models.Comment
import com.example.bottomnavtienda.data.models.StoreInfo

class CommentMock {
    fun loadComments(): List<Comment>{
        return listOf(
            Comment("https://upload.wikimedia.org/wikipedia/commons/f/f4/User_Avatar_2.png","Pepito Perez","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500"),
            Comment("https://upload.wikimedia.org/wikipedia/commons/f/f4/User_Avatar_2.png","Juanito Perez","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500"),
            Comment("https://upload.wikimedia.org/wikipedia/commons/f/f4/User_Avatar_2.png","Pepito Bolaños","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500")
        )
    }
}