package com.example.login.data.api

import com.example.login.data.model.LoginRequest
import com.example.login.data.model.LoginResponse
import okhttp3.MultipartBody
import retrofit2.http.Body
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface ApiService {
    @POST("https://reqres.in/api/login")
    suspend fun login(
        @Body request: LoginRequest
    ): LoginResponse

    @Multipart
    @POST("validar/")
    suspend fun uploadPdf(
        @Part file: MultipartBody.Part
    )
}
