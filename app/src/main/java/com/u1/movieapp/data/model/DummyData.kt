package com.u1.movieapp.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DummyData(
        val id: Int,
        val title: String,
        val posterImg: Int,
        val date: String,
        val duration : String,
        val genre : String,
        val desc: String
) : Parcelable
