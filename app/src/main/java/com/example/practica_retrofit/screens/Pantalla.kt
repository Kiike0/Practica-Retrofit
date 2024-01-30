package com.example.practica_retrofit.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.Modifier
import com.example.practica_retrofit.data.ApiService
import com.example.practica_retrofit.data.User
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Composable
fun PantallaInicial(){

    Box(modifier = Modifier.fillMaxSize()) {
        UserList()
    }

}


@Composable
fun UserList() {
    val apiService: ApiService

    val retrofit = Retrofit.Builder()
        .baseUrl("https://api.example.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    apiService = retrofit.create(ApiService::class.java)

    val users = remember { mutableStateOf(listOf<User>()) }

    LaunchedEffect(Unit) {
        users.value = apiService.getUsers()
    }

    LazyColumn {
        items(users.value) { user ->
            Text(user.name)
        }
    }
}

