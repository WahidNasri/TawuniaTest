package com.wahid.tawuniya.repositories

import com.wahid.tawuniya.api.ApiService
import javax.inject.Inject

class UsersRepository @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun getUsers() = apiService.getUsers()
}