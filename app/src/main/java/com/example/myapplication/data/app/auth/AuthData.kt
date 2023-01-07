package com.example.myapplication.data.app.auth

data class AuthData(
    val name: String,
    val email: String,
    val phone: String
) {
    fun isValid(): Boolean {
        return name.isNotBlank() && email.isNotBlank() && phone.isNotBlank()
    }

    companion object  {
        fun empty(): AuthData {
            return AuthData(
                name = "",
                email = "",
                phone = ""
            )
        }
    }
}
