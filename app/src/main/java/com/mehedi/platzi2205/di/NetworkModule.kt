package com.mehedi.platzi2205.di

import com.mehedi.platzi2205.services.AuthService
import com.mehedi.platzi2205.services.UserService
import com.mehedi.platzi2205.utils.AuthInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit.Builder {
        return Retrofit.Builder()
            .baseUrl("https://api.escuelajs.co/api/v1/")
            .addConverterFactory(GsonConverterFactory.create())

    }

    @Provides
    @Singleton
    fun providesAuthService(retrofit: Retrofit.Builder): AuthService {
        return retrofit.build().create(AuthService::class.java)
    }


    @Provides
    @Singleton
    fun providesHttpClient(authInterceptor: AuthInterceptor): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(interceptor = authInterceptor).build()
    }


    @Provides
    @Singleton
    fun providesUserService(retrofit: Retrofit.Builder, client: OkHttpClient): UserService {
        return retrofit.client(client).build().create(UserService::class.java)
    }


}