package com.mehedi.platzi2205.utils

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthInterceptor @Inject constructor(private val prefManager: PrefManager) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
        request.addHeader("Authorization", "Bearer ${prefManager.getPref(Keys.ACCESS_TOKEN)}")
        return chain.proceed(request.build())
    }


}