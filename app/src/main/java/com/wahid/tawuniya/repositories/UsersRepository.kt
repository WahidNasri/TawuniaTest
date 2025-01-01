package com.wahid.tawuniya.repositories

import com.wahid.tawuniya.api.ApiClient

class UsersRepository {
    private val apiService = ApiClient.apiService

    suspend fun getUsers() = apiService.getUsers()
}