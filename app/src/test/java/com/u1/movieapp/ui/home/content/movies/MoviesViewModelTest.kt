package com.u1.movieapp.ui.home.content.movies

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.verify
import com.u1.movieapp.data.DataRepository
import com.u1.movieapp.data.local.DummyBuilder
import com.u1.movieapp.data.model.MoviesModel
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MoviesViewModelTest {

    private lateinit var viewModel: MoviesViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var repository: DataRepository

    @Mock
    private lateinit var listMoviesObserver: Observer<List<MoviesModel>>

    @Before
    fun setUp() {
        viewModel = MoviesViewModel(repository)
    }

    @Test
    fun getMoviesPopular() {
        val dummyData = DummyBuilder.generateMoviesData()
        val popularMovies = MutableLiveData<List<MoviesModel>>()
        popularMovies.value = dummyData
        `when`(repository.getMovies()).thenReturn(popularMovies)

        val movies = viewModel.getMoviesPopular().value
        verify(repository).getMovies()
        assertNotNull(popularMovies)
        assertEquals(2, movies?.size)

        viewModel.getMoviesPopular().observeForever(listMoviesObserver)
        verify(listMoviesObserver).onChanged(dummyData)
    }
}