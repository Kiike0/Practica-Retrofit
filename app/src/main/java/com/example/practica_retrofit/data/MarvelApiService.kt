package com.example.practica_retrofit.data

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelApiService {
    @GET("v1/public/characters")
    suspend fun getCharacters(@Query("apikey") apiKey: String): Response<CharacterDataWrapper>
}