package com.example.myapplication.data.mapper

import com.example.myapplication.data.app.session.Session
import com.example.myapplication.data.dto.session.SessionDto
import javax.inject.Inject

class SessionMapper @Inject constructor(): Mapper<SessionDto, Session> {
    override fun mapFromApp(type: Session): SessionDto {
        return SessionDto(
            token = type.token
        )
    }

    override fun mapToApp(type: SessionDto): Session {
        return Session(
            token = type.token ?: ""
        )
    }
}