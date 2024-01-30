package com.example.practica_retrofit.data

import retrofit2.http.Url
import java.util.Date

data class Character(
    val id: Int, // The unique ID of the character.
    val name: String, // The name of the character.
    val description: String, // A short bio or description of the character.
)
