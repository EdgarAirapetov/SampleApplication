package com.example.myapplication.data.dto.auth

import com.google.gson.annotations.SerializedName

data class AuthDataDto(
    @SerializedName("Name") val name: String?,
    @SerializedName("Email") val email: String?,
    @SerializedName("Phone") val phone: String?
)
