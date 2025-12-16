package com.example.login.data.api

import com.example.login.data.model.LoginRequest
import com.example.login.data.model.LoginResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("login")
    suspend fun login(
        @Body request: LoginRequest
    ): LoginResponse
}
