package com.example.practica_retrofit.screens

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.practica_retrofit.data.model.Result

@Composable
fun MoviesList(
    viewModel: PantallaViewModel
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        LazyColumn {
            items(viewModel.movies.results) { movie ->
                Text(text = movie.original_title)
            }
        }
    }
}

