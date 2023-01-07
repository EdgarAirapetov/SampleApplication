package com.example.myapplication.data.remote

import com.example.myapplication.data.app.auth.AuthData
import com.example.myapplication.data.dto.session.SessionDto
import com.example.myapplication.data.mapper.AuthMapper
import com.example.myapplication.remote.ApiFactory
import com.example.myapplication.remote.Resource
import com.example.myapplication.remote.checkResponse
import javax.inject.Inject

class AuthRemoteRepositoryImpl @Inject constructor(
    private val authMapper: AuthMapper,
    private val api: ApiFactory
) : AuthRemoteRepository {

    override suspend fun doAuth(authData: AuthData): Resource<SessionDto> {
        return checkResponse(api.authApi().doAuth())
    }
}
