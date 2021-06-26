package com.u1.movieapp.ui.home.content.series

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.verify
import com.u1.movieapp.data.DataRepository
import com.u1.movieapp.data.local.DummyBuilder
import com.u1.movieapp.data.model.SeriesModel
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class SeriesViewModelTest {

    private lateinit var viewModel: SeriesViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var repository: DataRepository

    @Mock
    private lateinit var listSeriesObserver: Observer<List<SeriesModel>>

    @Before
    fun setUp() {
        viewModel = SeriesViewModel(repository)
    }

    @Test
    fun getSeriesPopular() {
        val dummyData = DummyBuilder.generateSeriesData()
        val popularSeries = MutableLiveData<List<SeriesModel>>()
        popularSeries.value = dummyData
        `when`(repository.getSeries()).thenReturn(popularSeries)

        val series = viewModel.getSeriesPopular().value
        verify(repository).getSeries()
        assertNotNull(popularSeries)
        assertEquals(2, series?.size)

        viewModel.getSeriesPopular().observeForever(listSeriesObserver)
        verify(listSeriesObserver).onChanged(dummyData)
    }

}