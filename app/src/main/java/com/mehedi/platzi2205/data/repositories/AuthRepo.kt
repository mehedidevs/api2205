package com.mehedi.platzi2205.data.repositories

import com.mehedi.platzi2205.data.models.login.RequestLogin
import com.mehedi.platzi2205.data.models.login.ResponseLogin
import com.mehedi.platzi2205.services.AuthService
import retrofit2.Response
import javax.inject.Inject

class AuthRepo @Inject constructor(private val service: AuthService) {


    suspend fun login(requestLogin: RequestLogin): Response<ResponseLogin> {
        return service.login(requestLogin)
    }


}