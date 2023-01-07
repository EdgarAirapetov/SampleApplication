package com.example.myapplication.data.remote

import com.example.myapplication.data.app.auth.AuthData
import com.example.myapplication.data.dto.session.SessionDto
import com.example.myapplication.remote.Resource

interface AuthRemoteRepository {
    suspend fun doAuth(authData: AuthData): Resource<SessionDto>
}