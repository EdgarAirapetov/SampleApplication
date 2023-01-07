package com.example.myapplication.data.dto.session

import com.google.gson.annotations.SerializedName

data class SessionDto(
    @SerializedName("Token") val token: String?
)
