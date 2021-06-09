package com.u1.movieapp.ui.detail

import androidx.lifecycle.ViewModel
import com.u1.movieapp.data.model.DummyData
import com.u1.movieapp.data.utils.DummyBuilder

class DetailViewModel: ViewModel() {

    private var filmId = 0

    fun setSelectedFilm(filmId: Int) {
        this.filmId = filmId
    }

    fun getSelectedFilm(): DummyData {
        lateinit var selectedData: DummyData
        val data1 = DummyBuilder.generateDummyMoviesPlaying()
        val data2 = DummyBuilder.generateDummyMoviesPopular()
        val data3 = DummyBuilder.generateDummySeriesPlaying()
        val data4 = DummyBuilder.generateDummySeriesPopular()
        val allData = data1 + data2 + data3 + data4

        for (data in allData){
            if (data.id == filmId) {
                selectedData = data
            }
        }

        return selectedData
    }


}