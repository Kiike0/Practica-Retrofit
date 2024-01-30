package com.example.practica_retrofit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import com.example.practica_retrofit.data.RetrofitServiceFactory
import com.example.practica_retrofit.data.model.RemoteResult
import com.example.practica_retrofit.data.model.Result
import com.example.practica_retrofit.screens.MoviesList
import com.example.practica_retrofit.screens.PantallaViewModel
import com.example.practica_retrofit.ui.theme.PracticaRetrofitTheme
import kotlinx.coroutines.launch

/**
 * Importante ver la función que está mas abajo en los comentarios
 */
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PracticaRetrofitTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    MoviesList(viewModel = PantallaViewModel())
                }
            }
        }
    }
}

/*

        Asi funciona si hago debug en el println(movies) puedo ver todas las peliculas de la lista
        de peliculas más populares de la API, pero no consigo pasarselo a la funcion composable para
        que se vea correctamente, he probado de todo, como por ejemplo crear esa estancia que ves ahi
        de movies y pasarselo a MoviesList como parametro (creandole una variable de lista de Result)
        pero nada de nada, no hago que imprima nada en pantalla. Por lo menos los pasos a seguir para
        conectar con una API con retrofit lo he hecho. Pero implementarlo no consigo hacer que funcione.

        NOTA: Creado el viewmodel para probar las corrutinas del viewModel pero tampoco funcionan ahí.
        Con viewModel ni siquiera se imprime los datos de las peliculas haciendo el debug.

        val service = RetrofitServiceFactory.makeRetrofitService()

        // Variable para almacenar las películas
        var movies: RemoteResult = RemoteResult(0, emptyList(), 0, 0)

        lifecycleScope.launch {
            val moviesResult = service.listPopularMovies("57911d91de2af702e18c21f53390a0d3", "US")
            movies = moviesResult

            println(movies)
        }
 */
