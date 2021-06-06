package com.u1.movieapp.ui.home.content.movies

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class MoviesViewModelTest {

    private lateinit var viewModel: MoviesViewModel

    @Before
    fun setUp() {
        viewModel = MoviesViewModel()
    }

    @Test
    fun getMoviesPopular() {
        val popularMovies = viewModel.getMoviesPopular()
        assertNotNull(popularMovies)
        assertEquals(4, popularMovies.size)
    }

    @Test
    fun getMoviesPlaying() {
        val playingMovies = viewModel.getMoviesPlaying()
        assertNotNull(playingMovies)
        assertEquals(7, playingMovies.size)
    }
}