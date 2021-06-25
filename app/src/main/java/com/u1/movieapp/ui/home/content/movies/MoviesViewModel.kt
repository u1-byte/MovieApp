package com.u1.movieapp.ui.home.content.movies

import androidx.lifecycle.ViewModel
import com.u1.movieapp.data.DataRepository

class MoviesViewModel(private val repo: DataRepository) : ViewModel() {
    fun getMoviesPopular() = repo.getMovies()
}