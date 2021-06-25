package com.u1.movieapp.ui.detail

import com.u1.movieapp.data.local.DummyBuilder
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class DetailViewModelTest {

    private lateinit var viewModel: DetailViewModel
    private val validationData = DummyBuilder.generateDummyMoviesPlaying()[0]
    private val validationId = validationData.id

    @Before
    fun setUp(){
        viewModel = DetailViewModel()
    }

    @Test
    fun getSelectedFilm() {
        viewModel.setSelectedFilm(validationId)
        val resultData = viewModel.getSelectedFilm()
        assertNotNull(resultData)
        assertEquals(validationData.id, resultData.id)
        assertEquals(validationData.title, resultData.title)
        assertEquals(validationData.date, resultData.date)
        assertEquals(validationData.duration, resultData.duration)
        assertEquals(validationData.genre, resultData.genre)
        assertEquals(validationData.posterImg, resultData.posterImg)
        assertEquals(validationData.desc, resultData.desc)
    }
}