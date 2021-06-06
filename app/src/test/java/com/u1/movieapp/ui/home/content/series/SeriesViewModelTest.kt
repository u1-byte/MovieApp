package com.u1.movieapp.ui.home.content.series

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class SeriesViewModelTest {

    private lateinit var viewModel: SeriesViewModel

    @Before
    fun setUp() {
        viewModel = SeriesViewModel()
    }

    @Test
    fun getSeriesPopular() {
        val popularSeries = viewModel.getSeriesPopular()
        assertNotNull(popularSeries)
        assertEquals(5, popularSeries.size)
    }

    @Test
    fun getSeriesPlaying() {
        val playingSeries = viewModel.getSeriesPlaying()
        assertNotNull(playingSeries)
        assertEquals(6, playingSeries.size)
    }
}