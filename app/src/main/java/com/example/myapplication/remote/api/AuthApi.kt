package com.example.myapplication.remote.api

import com.example.myapplication.data.dto.session.SessionDto
import retrofit2.Response
import retrofit2.http.GET

interface AuthApi {
    @GET("auth")
    suspend fun doAuth(): Response<SessionDto>
}