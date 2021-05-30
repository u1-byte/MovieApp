package com.u1.movieapp.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SeriesData(
        val title: String,
        val posterImg: Int,
        val airedDate: String,
        val totalEpisode : String,
        val genre : String,
        val desc: String,
        val viewType: Int
) : Parcelable
