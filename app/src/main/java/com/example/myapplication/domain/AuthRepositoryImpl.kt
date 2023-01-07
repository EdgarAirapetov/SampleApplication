package com.example.myapplication.domain

import com.example.myapplication.data.app.auth.AuthData
import com.example.myapplication.data.app.session.Session
import com.example.myapplication.data.mapper.SessionMapper
import com.example.myapplication.data.remote.AuthRemoteRepository
import com.example.myapplication.domain.repository.AuthRepository
import com.example.myapplication.remote.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val sessionMapper: SessionMapper,
    private val authRemoteRepository: AuthRemoteRepository
) : AuthRepository {

    override suspend fun doAuth(authData: AuthData): Flow<Session> = flow {
        when (val authResponse = authRemoteRepository.doAuth(authData = authData)) {
            is Resource.Success -> {
                emit(sessionMapper.mapToApp(type = authResponse.data!!))
            }
            is Resource.Error -> {
                throw Exception(authResponse.errorMessage)
            }
        }
    }
}
