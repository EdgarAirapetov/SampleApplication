package com.example.myapplication.presentation.di

import com.example.myapplication.remote.ApiFactory
import com.example.myapplication.remote.ApiFactoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteModule {
    @Provides
    @Singleton
    fun apiFactory(): ApiFactory {
        return ApiFactoryImpl()
    }
}