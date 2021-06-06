package com.u1.movieapp.ui.detail

import com.u1.movieapp.data.model.DummyData
import com.u1.movieapp.data.utils.DummyBuilder
import com.u1.movieapp.ui.home.content.movies.MoviesViewModel
import com.u1.movieapp.ui.home.content.series.SeriesViewModel
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class DetailActivityTest {

    private lateinit var moviesViewModel : MoviesViewModel
    private lateinit var seriesViewModel : SeriesViewModel
    private lateinit var dataFromFragment: DummyData

    @Before
    fun setUp(){
        moviesViewModel = MoviesViewModel()
        seriesViewModel = SeriesViewModel()

    }

    @Test
    fun setViewMovies() {
        dataFromFragment = moviesViewModel.getMoviesPopular()[0]

        //testing only one data from movies because all of them have same mechanism
        val dummyData = DummyBuilder.generateDummyMoviesPopular()[0]

        //check data from view model not null
        assertNotNull(dataFromFragment)

        //check data same as expected
        assertEquals(dummyData.posterImg, dataFromFragment.posterImg)
        assertEquals(dummyData.title, dataFromFragment.title)
        assertEquals(dummyData.genre, dataFromFragment.genre)
        assertEquals(dummyData.duration, dataFromFragment.duration)
        assertEquals(dummyData.date, dataFromFragment.date)
        assertEquals(dummyData.desc, dataFromFragment.desc)
    }

    @Test
    fun setViewSeries() {
        dataFromFragment = seriesViewModel.getSeriesPopular()[0]

        //testing only one data from movies because all of them have same mechanism
        val dummyData = DummyBuilder.generateDummySeriesPopular()[0]

        //check data from view model not null
        assertNotNull(dataFromFragment)

        //check data same as expected
        assertEquals(dummyData.posterImg, dataFromFragment.posterImg)
        assertEquals(dummyData.title, dataFromFragment.title)
        assertEquals(dummyData.genre, dataFromFragment.genre)
        assertEquals(dummyData.duration, dataFromFragment.duration)
        assertEquals(dummyData.date, dataFromFragment.date)
        assertEquals(dummyData.desc, dataFromFragment.desc)
    }
}