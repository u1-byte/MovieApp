package com.u1.movieapp.data.remote.response

import com.google.gson.annotations.SerializedName

data class SeriesPopularResponse (
    @SerializedName("poster_path")
    val poster: String,
    @SerializedName("name")
    val title: String,
    @SerializedName("first_air_date")
    val year: String,
    @SerializedName("id")
    val id: Int
)