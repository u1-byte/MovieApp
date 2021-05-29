package com.u1.movieapp.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MoviesData(
        val title: String,
        val posterImg: Int,
        val releaseDate: String,
        val duration : String,
        val genre : String,
        val desc: String
) : Parcelable
