package com.wahid.tawuniya.data.remote

import com.example.example.User
import retrofit2.http.GET

interface ApiService {
    @GET("users")
    suspend fun getUsers(): List<User>
}

