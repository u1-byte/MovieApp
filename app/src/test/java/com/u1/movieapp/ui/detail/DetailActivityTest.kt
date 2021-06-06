package com.u1.movieapp.ui.detail

import com.u1.movieapp.data.model.DummyData
import com.u1.movieapp.data.utils.DummyBuilder
import com.u1.movieapp.ui.home.content.movies.MoviesViewModel
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class DetailActivityTest {

    private lateinit var viewModel : MoviesViewModel
    private lateinit var dataFromFragment: DummyData

    @Before
    fun setUp(){
        viewModel = MoviesViewModel()
        dataFromFragment = viewModel.getMoviesPopular()[0]
    }

    @Test
    fun setView() {

        //testing only one data from movies because all of them have same mechanism
        val dummyData = DummyBuilder.generateDummyMoviesPopular()[0]

        assertNotNull(dataFromFragment)
        assertEquals(dummyData.posterImg, dataFromFragment.posterImg)
        assertEquals(dummyData.title, dataFromFragment.title)
        assertEquals(dummyData.genre, dataFromFragment.genre)
        assertEquals(dummyData.duration, dataFromFragment.duration)
        assertEquals(dummyData.date, dataFromFragment.date)
        assertEquals(dummyData.desc, dataFromFragment.desc)

    }
}