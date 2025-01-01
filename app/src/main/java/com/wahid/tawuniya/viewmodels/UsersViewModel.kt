package com.wahid.tawuniya.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.example.User
import com.wahid.tawuniya.repositories.UsersRepository
import com.wahid.tawuniya.data.local.UserPreferences
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UsersViewModel @Inject constructor(
    private val repository: UsersRepository,
    private val userPreferences: UserPreferences
) : ViewModel() {
    private val _users = MutableStateFlow<List<User>>(emptyList())
    val users: StateFlow<List<User>> = _users.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error.asStateFlow()

    private val _favoriteUsers = MutableStateFlow<Set<User>>(emptySet())
    val favoriteUsers: StateFlow<Set<User>> = _favoriteUsers.asStateFlow()

    init {
        loadFavoriteUsers()
    }

    private fun loadFavoriteUsers() {
        _favoriteUsers.value = userPreferences.getFavoriteUsers()
    }

    fun toggleFavorite(user: User) {
        viewModelScope.launch {
            if (user in _favoriteUsers.value) {
                userPreferences.removeUser(user)
            } else {
                userPreferences.saveUser(user)
            }
            _favoriteUsers.value = userPreferences.getFavoriteUsers()
        }
    }

    fun fetchUsers() {
        viewModelScope.launch {
            try {
                _isLoading.value = true
                _error.value = null
                _users.value = repository.getUsers()
            } catch (e: Exception) {
                _error.value = e.message ?: "An unknown error occurred"
            } finally {
                _isLoading.value = false
            }
        }
    }
}