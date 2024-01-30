package com.example.practica_retrofit.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practica_retrofit.data.RetrofitServiceFactory
import com.example.practica_retrofit.data.model.RemoteResult
import kotlinx.coroutines.launch

class PantallaViewModel : ViewModel() {
    val service = RetrofitServiceFactory.makeRetrofitService()

    // Variable para almacenar las películas
    var movies: RemoteResult = RemoteResult(0, emptyList(), 0, 0)

    fun moviesResult() : RemoteResult {
        viewModelScope.launch {
            val moviesResult = service.listPopularMovies("57911d91de2af702e18c21f53390a0d3", "US")
            movies = moviesResult

        }
        return movies
    }


}