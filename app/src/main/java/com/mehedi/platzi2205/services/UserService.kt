package com.mehedi.platzi2205.services

import com.mehedi.platzi2205.data.models.profile.ResponseProfile
import retrofit2.Response
import retrofit2.http.GET

interface UserService {

    @GET("auth/profile")
    suspend fun profile(): Response<ResponseProfile>


}