package com.mehedi.platzi2205.services

import com.mehedi.platzi2205.data.models.login.RequestLogin
import com.mehedi.platzi2205.data.models.login.ResponseLogin
import com.mehedi.platzi2205.data.models.registration.RequestRegistration
import com.mehedi.platzi2205.data.models.registration.ResponseRegistration
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {

    @POST("auth/login")
   suspend fun login(@Body requestLogin: RequestLogin): Response<ResponseLogin>

    @POST("users")
    suspend fun registration(@Body request: RequestRegistration): Response<ResponseRegistration>


}