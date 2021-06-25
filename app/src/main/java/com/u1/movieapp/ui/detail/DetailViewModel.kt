package com.u1.movieapp.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.u1.movieapp.data.DataRepository
import com.u1.movieapp.data.model.DummyData
import com.u1.movieapp.data.local.DummyBuilder
import com.u1.movieapp.data.model.DetailModel

class DetailViewModel(private val repo: DataRepository): ViewModel() {

    companion object {
        const val MOVIES_TYPE = 0
        const val SERIES_TYPE = 1
    }

    private lateinit var detailData: LiveData<DetailModel>

    fun setSelectedFilm(filmId: String, filmType: Int) {
        detailData = if (filmType == 0) {
            repo.getMoviesDetail(filmId)
        } else {
            repo.getSeriesDetail(filmId)
        }
    }

    fun getSelectedFilm() = detailData

}