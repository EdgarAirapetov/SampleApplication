package com.example.myapplication.domain.repository

import com.example.myapplication.data.app.auth.AuthData
import com.example.myapplication.data.app.session.Session
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    suspend fun doAuth(authData: AuthData): Flow<Session>
}