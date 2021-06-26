package com.u1.movieapp.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.verify
import com.u1.movieapp.data.DataRepository
import com.u1.movieapp.data.local.DummyBuilder
import com.u1.movieapp.data.model.DetailModel
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailViewModelTest {

    private lateinit var viewModel: DetailViewModel
    private val validationData = DummyBuilder.generateDetailMovies()
    private val validationId = validationData.id.toString()

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var repository: DataRepository

    @Mock
    private lateinit var detailObserver: Observer<DetailModel>

    @Before
    fun setUp(){
        viewModel = DetailViewModel(repository)
    }

    @Test
    fun getSelectedFilm() {
        val film = MutableLiveData<DetailModel>()
        film.value = validationData
        `when`(repository.getMoviesDetail(validationId)).thenReturn(film)
        viewModel.setSelectedFilm(validationId, 0)

        val resultData = viewModel.getSelectedFilm().value as DetailModel
        verify(repository).getMoviesDetail(validationId)

        assertNotNull(resultData)
        assertEquals(validationData.id, resultData.id)
        assertEquals(validationData.title, resultData.title)
        assertEquals(validationData.year, resultData.year)
        assertEquals(validationData.genres, resultData.genres)
        assertEquals(validationData.poster, resultData.poster)
        assertEquals(validationData.overview, resultData.overview)

        viewModel.getSelectedFilm().observeForever(detailObserver)
        verify(detailObserver).onChanged(validationData)
    }
}