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
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.example.practica_retrofit.BuildConfig
import com.example.practica_retrofit.data.MarvelApiService
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
    val retrofit = Retrofit.Builder()
        .baseUrl("https://gateway.marvel.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val marvelApiService: MarvelApiService = retrofit.create(MarvelApiService::class.java)

    val characters = remember { mutableStateOf(listOf<com.example.practica_retrofit.data.Character>()) }
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(coroutineScope) {
        val response = marvelApiService.getCharacters(BuildConfig.MARVEL_API_KEY)
        if (response.isSuccessful) {
            characters.value = response.body()?.data?.results ?: listOf()
        }
    }

    LazyColumn {
        items(characters.value) { character ->
            Text(character.name)
        }
    }
}
