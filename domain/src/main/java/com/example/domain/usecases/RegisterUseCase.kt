package com.example.domain.usecases

import com.example.data.repositories.AuthenticationRepository

class RegisterUseCase(private val authenticationRepository: AuthenticationRepository) {
    suspend operator fun invoke(email: String, password: String, username:String) =
        authenticationRepository.registerUser(email, password, username)
}