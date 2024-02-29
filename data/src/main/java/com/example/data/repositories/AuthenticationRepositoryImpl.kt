package com.example.data.repositories

import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import com.example.data.models.Result

import javax.inject.Inject

class AuthenticationRepositoryImpl @Inject constructor(private val firebaseAuth: FirebaseAuth) :
    AuthenticationRepository {
    override suspend fun registerUser(
        email: String,
        password: String,
        username: String
    ): Flow<Result<AuthResult>> =
        flow {
            try {
                emit(Result.Loading(true))
                val user = firebaseAuth.createUserWithEmailAndPassword(email, password).await()
                emit(Result.Success(user))
            } catch (e: Exception) {
                emit(Result.Error(e.message ?: "Registration failed"))
            } finally {
                emit(Result.Loading(false))
            }
        }
}

