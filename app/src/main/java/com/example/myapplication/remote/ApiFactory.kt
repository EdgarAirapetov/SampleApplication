package com.example.myapplication.remote

import com.example.myapplication.remote.api.AuthApi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

interface ApiFactory {
    fun authApi(): AuthApi
}

open class ApiFactoryImpl: ApiFactory {
    companion object {
        const val REQUEST_TIMEOUT = 60L
    }

    private var retrofit: Retrofit? = null

    override fun authApi() = authApi

    private val authApi: AuthApi by lazy {
        getClient().create(AuthApi::class.java)
    }

    private fun getClient(): Retrofit {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .client(getHttpClient())
                .baseUrl(getRootUrl())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit!!
    }

    private fun getHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(REQUEST_TIMEOUT, TimeUnit.SECONDS)
            .connectTimeout(REQUEST_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(REQUEST_TIMEOUT, TimeUnit.SECONDS)
            .build()
    }

    private fun getRootUrl(): String {
        return ""
    }
}