package com.u1.movieapp.data.remote.response

import com.google.gson.annotations.SerializedName

data class MoviesDetailResponse (
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("release_date")
    val year: String,
    @SerializedName("genres")
    val genres: List<GenreResponse>,
    @SerializedName("overview")
    val overview: String,
    @SerializedName("poster_path")
    val poster: String
)