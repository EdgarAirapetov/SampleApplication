package com.example.myapplication.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.data.app.auth.AuthData
import com.example.myapplication.data.app.session.Session
import com.example.myapplication.domain.repository.AuthRepository
import com.example.myapplication.presentation.utils.CoroutineContextProvider
import kotlinx.coroutines.CoroutineExceptionHandler
import javax.inject.Inject

class MainViewModel @Inject constructor(
    contextProvider: CoroutineContextProvider,
    private val authRepository: AuthRepository
) : BaseViewModel(contextProvider) {

    private val _authLiveData = MutableLiveData<Session>()
    val authLiveData: LiveData<Session> = _authLiveData

    private val _errorLiveData = MutableLiveData<String>()
    val errorLiveData: LiveData<String> = _errorLiveData

    private val _authDataValidLiveData = MutableLiveData<Boolean>()
    val authDataValidLiveData: LiveData<Boolean> = _authDataValidLiveData

    private var authData = AuthData.empty()
        set(value) {
            field = value
            _authDataValidLiveData.postValue(field.isValid())
        }

    override val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
        _errorLiveData.postValue(exception.message ?: "Error")
    }

    fun sendAuthData() {
        launchCoroutineIO {
            doAuth()
        }
    }

    private suspend fun doAuth() {
        authRepository.doAuth(authData = authData).collect {
            _authLiveData.postValue(it)
        }
    }

    fun getAuthData(): AuthData {
        return authData
    }

    fun updateAuthData(authData: AuthData) {
        this.authData = authData
    }
}