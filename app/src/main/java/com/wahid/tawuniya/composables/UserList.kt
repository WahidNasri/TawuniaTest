package com.wahid.tawuniya.composables

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.wahid.tawuniya.viewmodels.UsersViewModel

@Composable
fun UsersList(
    modifier: Modifier = Modifier,
    viewModel: UsersViewModel
) {
    val users by viewModel.users.collectAsState()
    val favoriteUsers by viewModel.favoriteUsers.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    val error by viewModel.error.collectAsState()

    Box(modifier = modifier.fillMaxSize()) {
        when {
            isLoading -> {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            error != null -> {
                Text(
                    text = error ?: "",
                    color = MaterialTheme.colorScheme.error,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .padding(16.dp)
                )
            }

            else -> {
                LazyColumn {
                    items(users) { user ->
                        UserItem(
                            user = user,
                            isFavorite = user in favoriteUsers,
                            onFavoriteClick = { viewModel.toggleFavorite(it) }

                        )
                    }
                }
            }
        }
    }
}