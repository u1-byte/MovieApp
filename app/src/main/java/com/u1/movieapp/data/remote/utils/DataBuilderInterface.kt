package com.u1.movieapp.data.remote.utils

import androidx.lifecycle.LiveData
import com.u1.movieapp.data.model.DetailModel
import com.u1.movieapp.data.model.MoviesModel
import com.u1.movieapp.data.model.SeriesModel

interface DataBuilderInterface {

    fun getMovies(): LiveData<List<MoviesModel>>

    fun getSeries(): LiveData<List<SeriesModel>>

    fun getMoviesDetail(id: String): LiveData<DetailModel>

    fun getSeriesDetail(id: String): LiveData<DetailModel>
}