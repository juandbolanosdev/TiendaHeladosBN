package com.example.bottomnavtienda.data.repositories

import android.graphics.Bitmap
import com.google.firebase.auth.*
import com.google.firebase.auth.ktx.userProfileChangeRequest
import com.google.firebase.storage.StorageReference
import kotlinx.coroutines.tasks.await
import java.io.ByteArrayOutputStream

class UserRepository(private val dataSource: FirebaseAuth, private val dataSourceStorage: StorageReference) {
    suspend fun loggedIn(): FirebaseUser? {
        return dataSource.currentUser
    }

    suspend fun signUp(email: String, name: String, password: String): FirebaseUser? {
        try {
            dataSource.createUserWithEmailAndPassword(email, password).await()
            val user = dataSource.currentUser
            val profileUpdate = userProfileChangeRequest {
                displayName = name

            }
            user!!.updateProfile(profileUpdate).await()
            return user

        } catch (e: FirebaseAuthUserCollisionException) {
            throw Error("Correo en uso")

        }
    }

    suspend fun login(email: String, pass: String): FirebaseUser? {
        try {
            dataSource.signInWithEmailAndPassword(email, pass).await()
            return dataSource.currentUser
        } catch (e: FirebaseAuthInvalidCredentialsException) {
            throw Error("Credenciales invalidas")
        } catch (e: FirebaseAuthInvalidUserException) {
            throw Error("Usuario deshabilitado")
        }
    }

    suspend fun logOut(): FirebaseUser? {
        dataSource.signOut()
        return null
    }

    suspend fun uploadImage(bitmap: Bitmap): FirebaseUser? {
        val baos = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos)
        val data = baos.toByteArray()
        val user = dataSource.currentUser
        val profileRef = dataSourceStorage.child("${user!!.uid}.jpg")
        profileRef.putBytes(data).await()
        val uri = profileRef.downloadUrl.await()
        val profileUpdate = userProfileChangeRequest {
            photoUri = uri
        }
        user!!.updateProfile(profileUpdate).await()
        return user
    }
}