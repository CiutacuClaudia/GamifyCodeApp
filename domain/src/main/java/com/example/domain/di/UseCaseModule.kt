package com.example.domain.di

import com.example.data.repositories.AuthenticationRepository
import com.example.domain.usecases.RegisterUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Singleton
    @Provides
    fun provideRegisterUseCase(repository: AuthenticationRepository) = RegisterUseCase(repository)
}