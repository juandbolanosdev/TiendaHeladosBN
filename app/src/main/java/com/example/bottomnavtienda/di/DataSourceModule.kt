package com.example.bottomnavtienda.di



import com.example.bottomnavtienda.data.mocks.CommentMock
import com.example.bottomnavtienda.data.mocks.ProductMock
import com.example.bottomnavtienda.data.mocks.StoreInfoMock
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import org.koin.dsl.module

val dataSourceModule = module {
    single { StoreInfoMock() }
    single { CommentMock() }
    single { ProductMock() }
    single { FirebaseFirestore.getInstance() }
    single { FirebaseAuth.getInstance() }
    single { FirebaseStorage.getInstance().getReference() }
}
