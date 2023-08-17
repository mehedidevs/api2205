package com.mehedi.platzi2205.data.repositories

import com.mehedi.platzi2205.data.models.login.RequestLogin
import com.mehedi.platzi2205.data.models.login.ResponseLogin
import com.mehedi.platzi2205.data.models.profile.ResponseProfile
import com.mehedi.platzi2205.data.models.registration.RequestRegistration
import com.mehedi.platzi2205.data.models.registration.ResponseRegistration
import com.mehedi.platzi2205.services.AuthService
import com.mehedi.platzi2205.services.UserService
import retrofit2.Response
import javax.inject.Inject

class UserRepo @Inject constructor(private val service: UserService) {


    suspend fun profile(): Response<ResponseProfile> {
        return service.profile()
    }


}