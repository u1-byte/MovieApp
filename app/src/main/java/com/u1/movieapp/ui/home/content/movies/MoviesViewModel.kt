package com.u1.movieapp.ui.home.content.movies

import androidx.lifecycle.ViewModel
import com.u1.movieapp.data.local.model.DummyData
import com.u1.movieapp.data.local.utils.DummyBuilder

class MoviesViewModel : ViewModel() {
    fun getMoviesPopular(): List<DummyData> = DummyBuilder.generateDummyMoviesPopular()
}