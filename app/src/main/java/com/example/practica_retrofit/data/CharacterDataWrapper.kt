package com.example.practica_retrofit.data

data class CharacterDataWrapper(
    val code: Int, // The HTTP status code of the returned result.
    val status: String, // A string description of the call status.
    val copyright: String, // The copyright notice for the returned result.
    val attributionText: String, // The attribution notice for this result.
    val data: CharacterDataContainer // The results returned by the call.
)
