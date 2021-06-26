package com.u1.movieapp.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.eq
import com.nhaarman.mockitokotlin2.verify
import com.u1.movieapp.data.local.DummyBuilder
import com.u1.movieapp.data.remote.utils.DataSources
import com.u1.movieapp.utils.LiveDataTesting
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock

class DataRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val dataMock = mock(DataSources::class.java)
    private val fakeRepo = FakeRepositoryTest(dataMock)

    private val moviesResponse = DummyBuilder.generateMoviesResponse()
    private val idMov = moviesResponse[0].id.toString()
    private val moviesDetailResponse = DummyBuilder.generateDetailMoviesResponse()

    private val seriesResponse = DummyBuilder.generateSeriesResponse()
    private val idSeries = seriesResponse[0].id.toString()
    private val seriesDetailResponse = DummyBuilder.generateDetailSeriesResponse()


    @Test
    fun getMovies() {
        doAnswer { invocation ->
            (invocation.arguments[0] as DataSources.LoadMoviesListCallback).onMoviesLoad(
                    moviesResponse
            )
            null
        }.`when`(dataMock).getMoviesList(any())

        val movieEntities = LiveDataTesting.getValue(fakeRepo.getMovies())

        verify(dataMock).getMoviesList(any())
        assertNotNull(movieEntities)
        assertEquals(moviesResponse.size, movieEntities.size)
    }

    @Test
    fun getSeries() {
        doAnswer { invocation ->
            (invocation.arguments[0] as DataSources.LoadSeriesListCallback).onSeriesLoad(
                    seriesResponse
            )
            null
        }.`when`(dataMock).getSeriesList(any())

        val seriesEntities = LiveDataTesting.getValue(fakeRepo.getSeries())

        verify(dataMock).getSeriesList(any())
        assertNotNull(seriesEntities)
        assertEquals(seriesResponse.size, seriesEntities.size)
    }

    @Test
    fun getDetailMovies() {
        doAnswer { invocation ->
            (invocation.arguments[0] as DataSources.LoadDetailMoviesCallback).onDetailMoviesLoad(
                    moviesDetailResponse
            )
            null
        }.`when`(dataMock).getDetailMovies(any(), eq(idMov))

        val movieDetailEntity = LiveDataTesting.getValue(fakeRepo.getMoviesDetail(idMov))

        verify(dataMock).getDetailMovies(any(), eq(idMov))
        assertNotNull(movieDetailEntity)
        assertEquals(moviesDetailResponse.id, movieDetailEntity.id)
    }

    @Test
    fun getDetailSeries() {
        doAnswer { invocation ->
            (invocation.arguments[0] as DataSources.LoadDetailSeriesCallback).onDetailSeriesLoad(
                    seriesDetailResponse
            )
            null
        }.`when`(dataMock).getDetailSeries(any(), eq(idSeries))

        val tvShowDetailEntity = LiveDataTesting.getValue(fakeRepo.getSeriesDetail(idSeries))

        verify(dataMock).getDetailSeries(any(), eq(idSeries))
        assertNotNull(tvShowDetailEntity)
        assertEquals(seriesDetailResponse.id, tvShowDetailEntity.id)
    }

}