package com.u1.movieapp.ui.home.content.series

import androidx.lifecycle.ViewModel
import com.u1.movieapp.data.local.model.DummyData
import com.u1.movieapp.data.local.utils.DummyBuilder

class SeriesViewModel : ViewModel() {
    fun getSeriesPopular(): List<DummyData> = DummyBuilder.generateDummySeriesPopular()
}