package com.wahid.tawuniya.data.local

import android.content.SharedPreferences
import com.example.example.User
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserPreferences @Inject constructor(
    private val sharedPreferences: SharedPreferences
) {
    private val gson = Gson()

    fun saveUser(user: User) {
        val users = getFavoriteUsers().toMutableSet()
        users.add(user)
        saveFavoriteUsers(users)
    }

    fun removeUser(user: User) {
        val users = getFavoriteUsers().toMutableSet()
        users.remove(user)
        saveFavoriteUsers(users)
    }

    fun getFavoriteUsers(): Set<User> {
        val json = sharedPreferences.getString(KEY_FAVORITE_USERS, "[]")
        val type = object : TypeToken<Set<User>>() {}.type
        return gson.fromJson(json, type) ?: emptySet()
    }

    private fun saveFavoriteUsers(users: Set<User>) {
        val json = gson.toJson(users)
        sharedPreferences.edit().putString(KEY_FAVORITE_USERS, json).apply()
    }

    companion object {
        private const val KEY_FAVORITE_USERS = "favorite_users"
    }
} 