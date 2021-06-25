package com.u1.movieapp.ui.detail

import androidx.lifecycle.ViewModel
import com.u1.movieapp.data.local.model.DummyData
import com.u1.movieapp.data.local.utils.DummyBuilder

class DetailViewModel: ViewModel() {

    private var filmId = 0

    fun setSelectedFilm(filmId: Int) {
        this.filmId = filmId
    }

    fun getSelectedFilm(): DummyData {
        lateinit var selectedData: DummyData
        val dataMovies = DummyBuilder.generateDummyMoviesPopular()
        val dataSeries = DummyBuilder.generateDummySeriesPopular()
        val allData = dataMovies + dataSeries

        for (data in allData){
            if (data.id == filmId) {
                selectedData = data
            }
        }

        return selectedData
    }


}