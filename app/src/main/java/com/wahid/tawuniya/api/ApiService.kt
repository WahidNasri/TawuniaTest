package com.wahid.tawuniya.api

import com.example.example.User
import retrofit2.Retrofit
import retrofit2.http.GET

interface ApiService {
    @GET("users")
    suspend fun getUsers(): List<User>
}

