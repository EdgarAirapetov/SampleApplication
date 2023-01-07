package com.example.myapplication.data.mapper

import com.example.myapplication.data.app.auth.AuthData
import com.example.myapplication.data.dto.auth.AuthDataDto
import javax.inject.Inject

class AuthMapper @Inject constructor(): Mapper<AuthDataDto, AuthData> {
    override fun mapFromApp(type: AuthData): AuthDataDto {
        return AuthDataDto(
            name = type.name,
            email = type.email,
            phone = type.phone
        )
    }

    override fun mapToApp(type: AuthDataDto): AuthData {
        return AuthData(
            name = type.name ?: "",
            email = type.email ?: "",
            phone = type.phone ?: ""
        )
    }
}