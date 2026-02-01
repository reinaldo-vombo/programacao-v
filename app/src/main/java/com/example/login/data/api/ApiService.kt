package com.example.login.data.api

import com.example.login.data.model.*
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("login")
    suspend fun login(
        @Body request: LoginRequest
    ): LoginResponse
    @Multipart
@POST("validar/")
suspend fun uploadPdf(
    @Part file: MultipartBody.Part
): ValidacaoResponse
}
