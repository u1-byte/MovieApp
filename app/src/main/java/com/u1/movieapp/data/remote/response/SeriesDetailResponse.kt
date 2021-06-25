package com.u1.movieapp.data.remote.response

import com.google.gson.annotations.SerializedName

data class SeriesDetailResponse (
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val title: String,
    @SerializedName("first_air_date")
    val year: String,
    @SerializedName("genres")
    val genres: List<GenreResponse>,
    @SerializedName("overview")
    val overview: String,
    @SerializedName("poster_path")
    val poster: String
)