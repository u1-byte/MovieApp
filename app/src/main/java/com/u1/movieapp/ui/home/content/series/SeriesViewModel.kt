package com.u1.movieapp.ui.home.content.series

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.u1.movieapp.data.model.DummyData
import com.u1.movieapp.data.utils.DummyBuilder

class SeriesViewModel : ViewModel() {
    fun getSeriesPopular(): List<DummyData> = DummyBuilder.generateDummySeriesPopular()
    fun getSeriesPlaying(): List<DummyData> = DummyBuilder.generateDummySeriesPlaying()
}