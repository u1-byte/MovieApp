package com.u1.movieapp.ui.home.content.series

import androidx.lifecycle.ViewModel
import com.u1.movieapp.data.DataRepository

class SeriesViewModel(private val repo: DataRepository) : ViewModel() {
    fun getSeriesPopular() = repo.getSeries()
}