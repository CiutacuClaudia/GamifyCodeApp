package com.example.data.repositories

import com.example.data.models.Result
import com.google.firebase.auth.AuthResult
import kotlinx.coroutines.flow.Flow

interface AuthenticationRepository {

    suspend fun registerUser(email: String, password: String, username: String): Flow<Result<AuthResult>>
}